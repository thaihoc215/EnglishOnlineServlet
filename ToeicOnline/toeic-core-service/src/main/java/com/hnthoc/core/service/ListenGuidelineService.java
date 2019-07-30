package com.hnthoc.core.service;

public interface ListenGuidelineService {
    Object[] findListenGuidelineByProperties(String property, Object value, String sortExpression, String direction, Integer offset, Integer limit);
}
