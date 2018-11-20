package com.example.administrator.review_android.six_principles_of_design_patterns.lod;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 6.迪米特原则(Law Of Demeter)
 * 定义:也称为最少知识原则（Least Knowledge Principle）。
 * 虽然名字不同，但描述的是同一个原则：一个对象应该对其他对象有最少的了解。
 * 通俗地讲，一个类应该对自己需要耦合或调用的类知道的最小，类的内部如何实现与调用者或者依赖者没关系，
 * 调用者或者依赖者只需要知道它需要的方法即可，其他的可一概不用管。
 * 类与类之间的关系月密切，耦合度越大，当一个类发生改变时，对另一个类的影响也越大。
 * <p>
 * 迪米特法则还有一个英文解释是 Only talk to your immedate friends，
 * 翻译过来就是：只与直接的朋友通信。
 * 什么叫做直接的朋友呢？每个对象都必然会与其他对象有耦合关系，两个对象之间的耦合就成为朋友关系，
 * 这种关系的类型有很多，如组合、聚合、依赖等。
 * <p>
 * 描述：租户只需要和中介打交道，告诉他自己需要的条件，直接由中介找到合适的房间，不需要它提供几个房间，
 * 自己来选，降低耦合
 */

public class LawOfDemeter {
    //房间
    public class Room {
        public float area;
        public float price;

        public Room(float area, float price) {
            this.area = area;
            this.price = price;
        }
    }

    //中介
    public class Mediator {
        List<Room> mRooms = new ArrayList<>();

        public Mediator() {
            for (int i = 0; i < 5; i++) {
                mRooms.add(new Room(14 + i, (14 + i) * 150));
            }
        }

        public List<Room> getAllRooms() {
            return mRooms;
        }

        public Room getRoom(float roomArea, float roomPrice) {
            if (mRooms != null) {
                for (Room room : mRooms) {
                    if (isSuitable(room, roomArea, roomPrice)) {
                        Log.d("Tenant", "租到房间啦！" + room);
                        return room;
                    }
                }
            }

            return null;
        }

        private boolean isSuitable(Room room, float roomArea, float roomPrice) {
            return Math.abs(room.price - roomPrice) < Tenant.diffPirce
                    && Math.abs(room.area - roomArea) < Tenant.diffArea;
        }
    }


    //租户
    public class Tenant {
        public float roomArea;
        public float roomPrice;
        public static final float diffPirce = 100.00f;
        public static final float diffArea = 0.0001f;

        public void rentRoom(Mediator mediator) {
            Log.d("Tenant", "租到房间啦！" + mediator.getRoom(roomArea, roomPrice));
        }

    }
}
