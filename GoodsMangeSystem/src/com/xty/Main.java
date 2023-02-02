package com.xty;

import com.xty.bean.Goods;
import com.xty.dao.impl.GoodsDaoImpl;
import com.xty.service.impl.GoodsServiceImpl;
import com.xty.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static void goodsMange() {
        Outer:
        while (true) {
            System.out.println("1.添加商品");
            System.out.println("2.查询商品");
            System.out.println("3.删除商品");
            System.out.println("4.修改商品");
            System.out.println("5.退出系统");

            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();

            switch (i) {
                case 1: {
                    System.out.println("请输入商品名称：");
                    String name = scanner.next();
                    System.out.println("请输入商品价格：");
                    double price = scanner.nextDouble();
                    System.out.println("请输入商品数量：");
                    int count = scanner.nextInt();
                    boolean b = new GoodsServiceImpl().addGoods(name, price, count);
                    if (b) {
                        System.out.println("商品添加成功！");
                    } else {
                        System.out.println("商品添加失败！");
                    }
                }
                break;
                case 2: {
                    System.out.println("1.查询全部商品");
                    System.out.println("2.通过商品名查询商品信息");
                    System.out.println("3.通过商品编号查询商品信息");
                    int j = scanner.nextInt();
                    switch (j) {
                        case 1:
                            List<Goods> allGoods = new GoodsDaoImpl().getAllGoods();
                            System.out.println("=========== 全部商品 ============");
                            System.out.println("商品编号\t\t商品名称\t\t商品价格\t\t商品数量");
                            allGoods.forEach((g) -> {
                                System.out.print(g.getId());
                                System.out.print("\t\t");
                                System.out.print(g.getName());
                                System.out.print("\t\t");
                                System.out.print(g.getPrise());
                                System.out.print("\t\t");
                                System.out.print(g.getCount());
                                System.out.println();
                            });
                            System.out.println("============== ends ===============");
                            break;
                        case 2: {
                            System.out.println("请输入要查询的商品名：");
                            String name = scanner.next();
                            Goods goods = new GoodsDaoImpl().queryByName(name);
                            if (goods == null) {
                                System.out.println("无此商品！");
                                break;
                            }
                            System.out.println("商品编号\t\t商品名称\t\t商品价格\t\t商品数量");
                            System.out.print(goods.getId());
                            System.out.print("\t\t");
                            System.out.print(goods.getName());
                            System.out.print("\t\t");
                            System.out.print(goods.getPrise());
                            System.out.print("\t\t");
                            System.out.print(goods.getCount());
                            System.out.println();
                        }
                        break;
                        case 3: {
                            System.out.println("请输入要查询的商品编号：");
                            int id = scanner.nextInt();
                            Goods goods = new GoodsDaoImpl().queryById(id);
                            if (goods == null) {
                                System.out.println("无此商品！");
                                break;
                            }
                            System.out.println("商品编号\t\t商品名称\t\t商品价格\t\t商品数量");
                            System.out.print(goods.getId());
                            System.out.print("\t\t");
                            System.out.print(goods.getName());
                            System.out.print("\t\t");
                            System.out.print(goods.getPrise());
                            System.out.print("\t\t");
                            System.out.print(goods.getCount());
                            System.out.println();
                        }
                        break;
                    }
                }
                break;
                case 3: {
                    System.out.println("请输入要删除的商品编号：");
                    int id = scanner.nextInt();
                    if (new GoodsDaoImpl().removeById(id)) {
                        System.out.println("删除成功！");
                    } else {
                        System.out.println("删除失败！");
                    }

                }
                break;
                case 4: {
                    System.out.println("请输入要删除的商品编号：");
                    int id = scanner.nextInt();

                    Goods goods = new GoodsDaoImpl().queryById(id);

                    if (goods == null) {
                        System.out.println("无此商品！");
                        break;
                    }

                    System.out.println("商品编号\t\t商品名称\t\t商品价格\t\t商品数量");
                    System.out.print(goods.getId());
                    System.out.print("\t\t");
                    System.out.print(goods.getName());
                    System.out.print("\t\t");
                    System.out.print(goods.getPrise());
                    System.out.print("\t\t");
                    System.out.print(goods.getCount());
                    System.out.println();

                    Inner:
                    while (true) {
                        System.out.println("1.修改商品名称");
                        System.out.println("2.修改商品价格");
                        System.out.println("3.修改商品数量");
                        System.out.println("4.保存修改");
                        System.out.println("5.撤销修改并退出");

                        int j = scanner.nextInt();
                        switch (j) {
                            case 1:
                                System.out.println("请输入新的商品名称：");
                                String newName = scanner.next();
                                // 先修改 goods 对象，最后如果保存修改的话，再将修改存至数据库
                                goods.setName(newName);
                                break;
                            case 2:
                                System.out.println("请输入新的商品价格：");
                                double newPrice = scanner.nextDouble();
                                // 先修改 goods 对象，最后如果保存修改的话，再将修改存至数据库
                                goods.setPrise(newPrice);
                                break;
                            case 3:
                                System.out.println("请输入新的商品数量：");
                                int newCount = scanner.nextInt();
                                // 先修改 goods 对象，最后如果保存修改的话，再将修改存至数据库
                                goods.setCount(newCount);
                                break;
                            case 4:
                                // 将对 goods 对象的修改，作用于数据库中的数据
                                if (new GoodsDaoImpl().updateGoods(id, goods)) {
                                    System.out.println("修改成功！");
                                    break Inner;
                                } else {
                                    System.out.println("修改失败!");
                                }
                                break;
                            case 5:
                                break Inner;
                        }
                    }
                }
                break;
                case 5:
                    break Outer;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Out:
        while (true) {

            System.out.println("欢迎使用商品管理系统");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出");


            int i = scanner.nextInt();

            switch (i) {
                case 1: {
                    System.out.println("请输入账号：");
                    String uname = scanner.next();
                    System.out.println("请输入密码：");
                    String psd = scanner.next();
                    if (new UserServiceImpl().login(uname, psd)) {
                        System.out.println("登录成功");
                        // 转到商品管理模块
                        goodsMange();
                        break Out;
                    } else {
                        System.out.println("账号或密码有误，请重试！");
                    }
                }
                break;
                case 2:
                    System.out.println("请输入账号：");
                    String uname = scanner.next();
                    System.out.println("请输入昵称：");
                    String name = scanner.next();
                    System.out.println("请输入密码：");
                    String psd1 = scanner.next();
                    System.out.println("请确认密码：");
                    String psd2 = scanner.next();

                    if (!psd1.equals(psd2)) {
                        System.out.println("两次密码输入不一致！");
                        break;
                    }

                    if (new UserServiceImpl().regist(uname, name, psd2)) {
                        System.out.println("注册成功！");
                    } else {
                        System.out.println("注册失败！");
                    }

                    break;
                case 3:
                    break Out;
                default:
                    break;
            }
        }


    }
}
