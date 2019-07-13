package com.hnthoc.core.web.utils;

import com.hnthoc.core.web.command.AbstractCommand;
import org.apache.commons.lang.StringUtils;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    //get parameter from client
    public static void initSearchBean(HttpServletRequest request, AbstractCommand bean) {
        /*//sort by column
        new ParamEncoder(tableId).encodeParameterName(TableTagParameters.PARAMETER_SORT))
        //sort by direction
        new ParamEncoder(tableId).encodeParameterName(TableTagParameters.PARAMETER_ORDER))
        //first item
        (Integer.parseInt(request.getParameter((new ParamEncoder(tableId).encodeParameterName(TableTagParameters.PARAMETER_PAGE)))) - 1) * pageSize.
        // max item*/

        // display tag lib will send the data when click funtion in UI
        if (bean != null) {
            //sort by column
            String sortExpression = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_SORT));
            String sortDirection = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_ORDER));
            String pageStr = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE));

            Integer page = 1;
            if (!StringUtils.isEmpty(pageStr)) {
                page = Integer.valueOf(pageStr);
            }
            // set data to AbstractCommand
            bean.setPage(page);
            bean.setSortDirection(sortDirection);
            bean.setSortExpression(sortExpression);
            bean.setFirstItem((page - 1) * bean.getMaxPageItems());
        }

    }
}
