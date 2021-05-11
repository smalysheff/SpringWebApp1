package ru.smal;

import ru.smal.dao.PeopleDao;

public class Main {
    public static void main(String[] args) {
        PeopleDao peopleDao = new PeopleDao();

        peopleDao.index().forEach(System.out::println);

    }
}
