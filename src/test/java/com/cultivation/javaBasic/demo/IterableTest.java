package com.cultivation.javaBasic.demo;

import java.util.Iterator;

    public class IterableTest implements Iterable {

        @Override
        public Iterator iterator() {
            return new Iterator() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Object next() {
                    return null;
                }
            };
        }
    }
