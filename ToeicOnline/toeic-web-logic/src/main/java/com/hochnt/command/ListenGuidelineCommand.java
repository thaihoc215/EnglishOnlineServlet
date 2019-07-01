package com.hochnt.command;

import com.hnthoc.core.dto.ListenGuidelineDTO;
import com.hnthoc.core.web.command.AbstractCommand;

public class ListenGuidelineCommand extends AbstractCommand<ListenGuidelineDTO> {
    public ListenGuidelineCommand() {
        this.pojo = new ListenGuidelineDTO();
    }
}
