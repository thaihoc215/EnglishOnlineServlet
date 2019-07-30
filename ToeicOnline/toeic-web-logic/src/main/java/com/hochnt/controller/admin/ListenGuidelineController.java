package com.hochnt.controller.admin;

import com.hnthoc.core.dto.ListenGuidelineDTO;
import com.hnthoc.core.service.ListenGuidelineService;
import com.hnthoc.core.service.impl.ListenGuidelineServiceImpl;
import com.hnthoc.core.web.common.WebConstant;
import com.hnthoc.core.web.utils.RequestUtil;
import com.hochnt.command.ListenGuidelineCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin-guideline-listen-list.html")
public class ListenGuidelineController extends HttpServlet {

    private ListenGuidelineService listenGuidelineService = new ListenGuidelineServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListenGuidelineCommand listenGuidelineCommand = new ListenGuidelineCommand();

        // get list item for display tag table
        List<ListenGuidelineDTO> listenGuidelineDTOS = new ArrayList<ListenGuidelineDTO>();
        /*ListenGuidelineDTO dto = new ListenGuidelineDTO();
        dto.setTitle("Bai nghe 1");
        dto.setContent("Noi dung bai nghe 1");

        ListenGuidelineDTO dto2 = new ListenGuidelineDTO();
        dto.setTitle("Bai nghe 1");
        dto.setContent("Noi dung bai nghe 1");

        listenGuidelineDTOS.add(dto);
        listenGuidelineDTOS.add(dto2);

        listenGuidelineCommand.setListResult(listenGuidelineDTOS);
        listenGuidelineCommand.setMaxPageItems(1);
        listenGuidelineCommand.setTotalItems(listenGuidelineDTOS.size());*/

        listenGuidelineCommand.setMaxPageItems(2);
        RequestUtil.initSearchBean(req, listenGuidelineCommand);
        listenGuidelineDTOS = (List<ListenGuidelineDTO>) listenGuidelineService.findListenGuidelineByProperties(null, null, listenGuidelineCommand.getSortExpression(),
                listenGuidelineCommand.getSortDirection(), listenGuidelineCommand.getFirstItem(), listenGuidelineCommand.getMaxPageItems())[0];
//        req.setAttribute(WebConstant.LIST_ITEMS, listenGuidelineCommand);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}