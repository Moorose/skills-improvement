package service;

import directionallist.OneWayList;

public class Service {

    //  O(n^4 * L^3)
    public OneWayList<People> clearListByProf(OneWayList<People> peopleList, OneWayList<String> professions) {
        People p = peopleList.getFirstItem();   //  O(1)
        while (true) {  //  O(n)
            People nextPeople = peopleList.getNextItem(p);  //  O(n^2)
            if (!listHasProfession(p.getProfession(), professions)) {   // O(L^3)
                peopleList.remove(p);   //  O(n)
            }
            if (nextPeople == null) {
                return peopleList;
            }
            p = nextPeople;
        }
    }

    //  O(L^3)
    private boolean listHasProfession(String profession, OneWayList<String> professions) {
        String item = professions.getFirstItem();   //  O(1)
        while (true) {  //  O(L)
            if (profession.equals(item)) {
                return true;
            }
            item = professions.getNextItem(item);   //  O(L^2)
            if (item == null) {
                return false;
            }
        }
    }
}
