package com.cai.helppsy.tools;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Paging {

    public static List pagingList(int CntOfOnePage, int page, List list) {
        List responseList = new ArrayList();

        int initialValue = list.size() - 1 -(page-1)*CntOfOnePage;
        int condition = initialValue-(CntOfOnePage-1);

        for(int i = initialValue ; i >= condition && i >= 0; i--){
            responseList.add(list.get(i));
        }

        return responseList;
    }

    public static List<Integer> cnt(int CntOfOnePage, List list){
        List<Integer> pages = new ArrayList<>();
        int cnt = list.size();

        int intNUm = cnt/CntOfOnePage;
        double doubleNum = (double)cnt/CntOfOnePage;

        int repeatNum = 0;

        if(doubleNum > intNUm){
            repeatNum = intNUm+1;
        } else if (doubleNum == intNUm) {
            repeatNum = intNUm;
        }

        for(int i = 0; i<repeatNum; i++){
            pages.add(i+1);
        }

        return pages;
    }
}