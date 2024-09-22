package com.dydko.mkyong.java8functionmkyong.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8Predicate7 {
    public static void main(String[] args) {
        Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting(2, "linode", "linode.com");
        Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting(4, "google", "google.com");
        List<Hosting> list1 = Arrays.asList(h1, h2, h3, h4);

        List<Hosting> filterdList = HostingRepository.filterHosting(list1, isDeveloperFriendly());
        System.out.println(filterdList);
    }

    public static Predicate<Hosting> isDeveloperFriendly() {
        return n -> n.getName().equals("linode");
    }
}