package com.fast.programming.service.condition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bowen.yan
 * @since 2016-09-16
 */
public class ExtendsSuper {
    public void testSuper() {
        List<? super Apple> apples = new ArrayList<Food>();
        // apples.add(new Fruit()); /* compile error */
        apples.add(new Apple());
        apples.add(new RedApple());
        apples.add(new BigRedApple());
    }

    private void testExtends() {
//        List<? extends Food> applesNew = new ArrayList<RedApple>();
//        applesNew.add(new Apple());
//        applesNew.add(new RedApple());
//        applesNew.add(new BigRedApple());
    }

    class Food {
        protected String getName() {
            return "Food";
        }

        public void println() {
            System.out.println(getName());
        }
    }

    class Fruit extends Food {
        @Override
        protected String getName() {
            return "Fruit";
        }
    }

    class Apple extends Fruit {
        @Override
        protected String getName() {
            return "Apple";
        }
    }

    class RedApple extends Apple {
        @Override
        protected String getName() {
            return "RedApple";
        }
    }

    class BigRedApple extends Apple {
        @Override
        protected String getName() {
            return "BigRedApple";
        }
    }

    public static void main(String[] args) {
        ExtendsSuper extendsSuper = new ExtendsSuper();
        extendsSuper.testSuper();
    }
}

