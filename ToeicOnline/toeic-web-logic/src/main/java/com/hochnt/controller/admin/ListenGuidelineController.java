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
import java.util.List;
import java.util.ResourceBundle;

@WebServlet("/admin-guideline-listen-list.html")
public class ListenGuidelineController extends HttpServlet {

    private ListenGuidelineService listenGuidelineService = new ListenGuidelineServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListenGuidelineCommand listenGuidelineCommand = new ListenGuidelineCommand();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");

       /* listenGuidelineCommand.setMaxPageItems(2);
        RequestUtil.initSearchBean(req, listenGuidelineCommand);
        // get list item for display tag table
        Object[] listenGuidelineObj = listenGuidelineService.findListenGuidelineByProperties(null, null, listenGuidelineCommand.getSortExpression(),
                listenGuidelineCommand.getSortDirection(), listenGuidelineCommand.getFirstItem(), listenGuidelineCommand.getMaxPageItems());
        listenGuidelineCommand.setListResult((List<ListenGuidelineDTO>) listenGuidelineObj[0]);
        listenGuidelineCommand.setTotalItems(Integer.parseInt(listenGuidelineObj[1].toString()));*/
        req.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
        req.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.success"));
        req.setAttribute(WebConstant.LIST_ITEMS, listenGuidelineCommand);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}