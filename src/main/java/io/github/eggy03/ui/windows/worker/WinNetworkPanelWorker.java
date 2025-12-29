package io.github.eggy03.ui.windows.worker;

import io.github.eggy03.ferrumx.windows.entity.compounded.MsftNetAdapterToIpAndDnsAndProfile;
import io.github.eggy03.ferrumx.windows.entity.network.MsftDnsClientServerAddress;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetConnectionProfile;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetIpAddress;
import io.github.eggy03.ferrumx.windows.service.compounded.MsftNetAdapterToIpAndDnsAndProfileService;
import io.github.eggy03.ui.windows.constant.WMIConstants;
import io.github.eggy03.ui.windows.utilities.WMIBooleanUtility;
import io.github.eggy03.ui.windows.utilities.WMINetworkUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Slf4j
public class WinNetworkPanelWorker extends SwingWorker<List<MsftNetAdapterToIpAndDnsAndProfile>, Void> {

    private final JComboBox<Long> networkIndexComboBox;
    private final List<JTextField> networkFields;
    private final List<JEditorPane> networkEditorPanes;

    @Override
    protected List<MsftNetAdapterToIpAndDnsAndProfile> doInBackground() {
        return new MsftNetAdapterToIpAndDnsAndProfileService().get(15L);
    }

    @Override
    protected void done() {
        try {
            List<MsftNetAdapterToIpAndDnsAndProfile> netList = get();
            if(netList.isEmpty()) {
                log.info("No entries for MsftNetAdapter were found");
                return;
            }
            log.info("Found {} MsftNetAdapter entry/entries", netList.size());

            // populate the combo box with network interface indexes
            netList.forEach(net-> networkIndexComboBox.addItem(net.getInterfaceIndex()));
            // populate fields and editor panes for the first entry in the combo box
            populate(netList);
            // add a listener to the combo box to re-populate fields on new selection
            networkIndexComboBox.addActionListener(selectAction -> populate(netList));

        } catch (InterruptedException e) {
            log.error("Network Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Network Fetch Failed", e);
        }
    }

    private void populate(List<MsftNetAdapterToIpAndDnsAndProfile> netList) {

        String selectedItem = String.valueOf(networkIndexComboBox.getSelectedItem());
        if(selectedItem==null || selectedItem.isBlank())
            return;

        Long interfaceIndex = Long.valueOf(selectedItem);
        Optional<MsftNetAdapterToIpAndDnsAndProfile> currentNetOptional = netList
                .stream()
                .filter(net->
                        net.getInterfaceIndex()!=null && net.getInterfaceIndex().equals(interfaceIndex)
                )
                .findFirst();

        if(currentNetOptional.isEmpty())
            return;

        MsftNetAdapterToIpAndDnsAndProfile currentNet = currentNetOptional.get();
        MsftNetAdapter currentAdapter = currentNet.getAdapter();
        List<MsftNetIpAddress> currentNetIpAddressList = currentNet.getIpAddressList();
        List<MsftDnsClientServerAddress> currentDnsAddressList = currentNet.getDnsClientServerAddressList();
        List<MsftNetConnectionProfile> currentConnectionProfileList = currentNet.getNetConnectionProfileList();

        if(currentAdapter!=null){
            networkFields.get(0).setText(currentAdapter.getDeviceId());
            networkFields.get(1).setText(currentAdapter.getInterfaceName());
            networkFields.get(2).setText(currentAdapter.getDriverVersion());
            networkFields.get(3).setText(currentAdapter.getDriverDate());
            networkFields.get(4).setText(String.valueOf(currentAdapter.getInterfaceType())); //not parsed cause long list
            networkFields.get(5).setText(currentAdapter.getLinkLayerAddress());
            networkFields.get(6).setText(currentAdapter.getLinkSpeed());
            networkFields.get(7).setText(WMIConstants.resolveMsftNetAdapterMediaConnectState(currentAdapter.getMediaConnectState()));
            networkFields.get(8).setText(currentAdapter.getMediaType());
            networkFields.get(9).setText(WMINetworkUtility.resolveNetworkSpeedInMbps(currentAdapter.getReceiveLinkSpeedRaw()));
            networkFields.get(10).setText(WMINetworkUtility.resolveNetworkSpeedInMbps(currentAdapter.getTransmitLinkSpeedRaw()));
            networkFields.get(11).setText(WMIBooleanUtility.resolveBoolean(currentAdapter.isFullDuplex()));
            networkFields.get(12).setText(WMIBooleanUtility.resolveBoolean(currentAdapter.isVirtual()));
            networkFields.get(13).setText(currentAdapter.getStatus());
            networkFields.get(14).setText(currentAdapter.getPnpDeviceId());
        }

        JEditorPane ipAddressPane = networkEditorPanes.get(0);
        JEditorPane dnsAddressPane = networkEditorPanes.get(1);
        JEditorPane connectionProfilePane = networkEditorPanes.get(2);
        // reset their contents on every invoke of this function
        ipAddressPane.setText(null);
        dnsAddressPane.setText(null);
        connectionProfilePane.setText(null);


        if(currentNetIpAddressList!=null && !currentNetIpAddressList.isEmpty()) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html><body>");
            currentNetIpAddressList.forEach(ip -> stringBuilder
                    .append("<b>IP Interface Index:</b> ").append(ip.getInterfaceIndex()).append("<br>")
                    .append("<b>IP Interface Alias:</b> ").append(ip.getInterfaceAlias()).append("<br>")
                    .append("<b>Address Family:</b> ").append(WMIConstants.resolveMsftIPvAddressFamily(ip.getAddressFamily())).append("<br>")
                    .append("<b>IPv4 Address:</b> ").append(ip.getIpv4Address()).append("<br>")
                    .append("<b>IPv6 Address:</b> ").append(ip.getIpv6Address()).append("<br>")
                    .append("<b>Type:</b> ").append(WMIConstants.resolveMsftNetIpAddressType(ip.getType())).append("<br>")
                    .append("<b>Prefix Origin:</b> ").append(WMIConstants.resolveMsftNetIpAddressPrefixOrigin(ip.getPrefixOrigin())).append("<br>")
                    .append("<b>Suffix Origin:</b> ").append(WMIConstants.resolveMsftNetIpAddressSuffixOrigin(ip.getSuffixOrigin())).append("<br><br>")
            );
            stringBuilder.append("</body></html>");

            ipAddressPane.setText(stringBuilder.toString());
        }

        if(currentDnsAddressList!=null && !currentDnsAddressList.isEmpty()) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html><body>");
            currentDnsAddressList.forEach(dns -> stringBuilder
                    .append("<b>DNS Interface Index:</b> ").append(dns.getInterfaceIndex()).append("<br>")
                    .append("<b>DNS Interface Alias:</b> ").append(dns.getInterfaceAlias()).append("<br>")
                    .append("<b>Address Family:</b> ").append(WMIConstants.resolveMsftIPvAddressFamily(dns.getAddressFamily())).append("<br>")
                    .append("<b>DNS Server Addresses:</b> ").append(dns.getDnsServerAddresses()).append("<br><br>")
            );
            stringBuilder.append("</body></html>");

            dnsAddressPane.setText(stringBuilder.toString());
        }

        if(currentConnectionProfileList!=null && !currentConnectionProfileList.isEmpty()) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html><body>");
            currentConnectionProfileList.forEach(profile -> stringBuilder
                    .append("<b>Profile Interface Index:</b> ").append(profile.getInterfaceIndex()).append("<br>")
                    .append("<b>Connection Interface Alias:</b> ").append(profile.getInterfaceAlias()).append("<br>")
                    .append("<b>Category:</b> ").append(WMIConstants.resolveMsftNetConnectionProfileNetworkCategory(profile.getNetworkCategory())).append("<br>")
                    .append("<b>Domain Auth Kind:</b> ").append(WMIConstants.resolveMsftNetConnectionProfileDomainAuthenticationKind(profile.getDomainAuthenticationKind())).append("<br>")
                    .append("<b>IPv4 Connectivity:</b> ").append(WMIConstants.resolveMsftNetConnectionProfileConnectivity(profile.getIpv4Connectivity())).append("<br>")
                    .append("<b>IPv6 Connectivity:</b> ").append(WMIConstants.resolveMsftNetConnectionProfileConnectivity(profile.getIpv6Connectivity())).append("<br><br>")
            );
            stringBuilder.append("</body></html>");

            connectionProfilePane.setText(stringBuilder.toString());
        }

    }
}
