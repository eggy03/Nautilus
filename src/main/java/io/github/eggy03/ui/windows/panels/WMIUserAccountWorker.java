package io.github.eggy03.ui.windows.panels;

import io.github.eggy03.ferrumx.windows.entity.user.Win32UserAccount;
import io.github.eggy03.ferrumx.windows.service.user.Win32UserAccountService;
import io.github.eggy03.ui.windows.constant.WMIConstants;
import io.github.eggy03.ui.windows.utilities.WMIBooleanUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Slf4j
public class WMIUserAccountWorker extends SwingWorker<List<Win32UserAccount>, Void> {

    private final JComboBox<String> userAccountSIDComboBox;
    private final List<JTextField> userAccountFields;

    @Override
    protected List<Win32UserAccount> doInBackground() {
        return new Win32UserAccountService().get(15L);
    }

    @Override
    protected void done() {
        try {
            List<Win32UserAccount> userAccountList = get();
            if(userAccountList.isEmpty()) {
                log.info("No entries for Win32UserAccount were found");
                return;
            }
            log.info("Found {} Win32UserAccount entry/entries", userAccountList.size());

            // fill the combo box with user account SIDs
            userAccountList.forEach(account ->userAccountSIDComboBox.addItem(account.getSid()));
            // populate fields for the first entry in the combo box
            populateFields(userAccountList);
            // add a listener to the combo box to re-populate fields on new selection
            userAccountSIDComboBox.addActionListener(selectEvent-> populateFields(userAccountList));

        } catch (InterruptedException e) {
            log.error("User Account Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("User Account Fetch Failed", e);
        }
    }

    private void populateFields(List<Win32UserAccount> userAccountList) {
        String userAccountSid = String.valueOf(userAccountSIDComboBox.getSelectedItem());

        Optional<Win32UserAccount> optionalAccount = userAccountList
                .stream()
                .filter(account-> account.getSid()!=null && account.getSid().equals(userAccountSid))
                .findFirst();

        if(optionalAccount.isEmpty())
            return;

        Win32UserAccount account = optionalAccount.get();

        userAccountFields.get(0).setText(account.getName());
        userAccountFields.get(1).setText(account.getCaption());
        userAccountFields.get(2).setText(account.getDomain());
        userAccountFields.get(3).setText(account.getDescription());
        userAccountFields.get(4).setText(WMIBooleanUtility.resolveBoolean(account.isPasswordRequired()));
        userAccountFields.get(5).setText(WMIBooleanUtility.resolveBoolean(account.isPasswordChangeable()));
        userAccountFields.get(6).setText(WMIBooleanUtility.resolveBoolean(account.doesPasswordExpire()));
        userAccountFields.get(7).setText(WMIBooleanUtility.resolveBoolean(account.isLocalAccount()));
        userAccountFields.get(8).setText(WMIBooleanUtility.resolveBoolean(account.isDisabled()));
        userAccountFields.get(9).setText(WMIBooleanUtility.resolveBoolean(account.isLockedOut()));
        userAccountFields.get(10).setText(WMIConstants.resolveWMIUserAccountType(account.getAccountType()));
        userAccountFields.get(11).setText(WMIConstants.resolveWMIUserAccountSidType(account.getSidType()));
        userAccountFields.get(12).setText(account.getStatus());
    }
}
