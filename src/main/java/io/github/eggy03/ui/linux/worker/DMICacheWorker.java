/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 * Copyright (C) 2026 Egg-03
 */
package io.github.eggy03.ui.linux.worker;

import io.github.eggy03.dmidecode.entity.processor.DMICache;
import io.github.eggy03.dmidecode.service.processor.DMICacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Slf4j
public class DMICacheWorker extends SwingWorker<List<DMICache>, Void> {

    private final JTextArea cacheTextArea;

    @Override
    protected List<DMICache> doInBackground() {
        return new DMICacheService().get(15);
    }

    @Override
    protected void done() {
        try {
            List<DMICache> dmiCacheList = get();
            if(dmiCacheList.isEmpty()) {
                log.info("No entries for DMICache were found");
                return;
            }
            log.info("Found {} DMICache entry/entries", dmiCacheList.size());

            StringBuilder sb = new StringBuilder();
            sb.append("Cache Characteristics:")
                    .append(System.lineSeparator());

            dmiCacheList.forEach(cache -> sb.append(System.lineSeparator())
                    .append("Socket Designation: ").append(cache.socketDesignation()).append(System.lineSeparator())
                    .append("Configuration: ").append(cache.configuration()).append(System.lineSeparator())
                    .append("Operational Mode: ").append(cache.operationalMode()).append(System.lineSeparator())
                    .append("Location: ").append(cache.location()).append(System.lineSeparator())
                    .append("Installed Size: ").append(cache.installedSize()).append(System.lineSeparator())
                    .append("Maximum Size: ").append(cache.maximumSize()).append(System.lineSeparator())
                    .append("Supported SRAM Types: ").append(cache.supportedSramTypes()).append(System.lineSeparator())
                    .append("Installed SRAM Type: ").append(cache.installedSramType()).append(System.lineSeparator())
                    .append("Speed: ").append(cache.speed()).append(System.lineSeparator())
                    .append("Error Correction Type: ").append(cache.errorCorrectionType()).append(System.lineSeparator())
                    .append("System Type: ").append(cache.systemType()).append(System.lineSeparator())
                    .append("Associativity: ").append(cache.associativity()).append(System.lineSeparator())
            );

            cacheTextArea.setText(sb.toString());
        } catch (ExecutionException e) {
            log.error("CPU Cache Fetch Failed", e);
        } catch (InterruptedException e) {
            log.error("CPU Cache Fetch Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
