package com.jr.test;

import com.jr.pojo.Stock;
import com.jr.pojo.Ware;
import com.jr.service.StockService;
import com.jr.service.UserService;
import com.jr.service.WareService;
import com.jr.service.impl.StockServiceImpl;
import com.jr.service.impl.UserServiceImpl;
import com.jr.service.impl.WareServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    Scanner input = new Scanner(System.in);
    UserService userService = new UserServiceImpl();
    WareService wareService = new WareServiceImpl();
    StockService stockService = new StockServiceImpl();


    public static void main(String[] args) {
        new Test().mainMenu();

    }

    public void mainMenu() {
        System.out.println("----------------------------------------------");
        System.out.println("----------------- 仓库管理系统-----------------");
        System.out.println("----------------------------------------------");
        System.out.print("1.注册\t2.登录\t3.退出\n");
        System.out.println("请选择您的操作序号：");
        int number=input.nextInt();
        if(number==1){
            registerMenu();
        }
        if (number == 2) {
            loginMenu();
        }
        if (number == 3) {
            System.out.println("----------谢谢使用！----------");
            System.exit(1);         //程序正常退出
        }
    }

    public void loginMenu() {
        System.out.println("----------------------------------------------");
        System.out.println("------------------- 用户登录-------------------");
        System.out.println("----------------------------------------------");
        boolean login = userService.login();
        if (login) {
            new Test().menu();
        }
    }

    public void registerMenu() {
        System.out.println("----------------------------------------------");
        System.out.println("------------------- 用户注册-------------------");
        System.out.println("----------------------------------------------");

        boolean boo = userService.register();
        if (boo) {
            System.out.println("注册成功！已返回菜单主界面");
            new Test().mainMenu();
        }
    }

    public void menu(){
        System.out.println("----------------------------------------------");
        System.out.println("------------------- 用户功能-------------------");
        System.out.println("----------------------------------------------");
        System.out.println("1.仓库管理\t2.库存管理\t3.产品管理\t4.返回上级菜单\t其他：退出程序");
        System.out.println("请输入您的操作序号：");
        int number = input.nextInt();
        if (number == 1) {
            new Test().wareMenu();
        } else if (number == 2) {
            new Test().stockMenu();
        } else if (number == 3) {
            new Test().productMenu();
        }else if (number == 4) {
            new Test().mainMenu();
        }
        else {
            System.out.println("----------谢谢使用！----------");
            System.exit(1);         //程序正常退出
        }
    }

    public void wareMenu() {
        System.out.println("----------------------------------------------");
        System.out.println("------------------- 仓库管理-------------------");
        System.out.println("----------------------------------------------");
        System.out.println("1.新建仓库\t2.修改仓库\t3.删除仓库\t4.查询仓库\t5.返回上级菜单\t其他：退出程序");
        System.out.println("请输入您的操作序号：");
        int number = input.nextInt();
        if (number == 1) {
            boolean b = wareService.addWare();
            if (b) {
                System.out.println("仓库新建成功！");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().wareMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }
        } else if (number == 2) {
            boolean b = wareService.changeWare();
            if (b) {
                System.out.println("仓库信息修改成功!");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().wareMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }
        } else if (number == 3) {
            boolean b = wareService.removeByName();
            if (b) {
                System.out.println("删除成功!");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().wareMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }else {
                System.out.println("删除失败!");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().wareMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }

        } else if (number == 4) {
            ArrayList<Ware> list = wareService.queryWares();
            if(list.size()>=1){
                System.out.println("仓库编号\t仓库名称\t仓库容量\t仓库地址");
                for (Ware ware : list) {
                    System.out.println(ware.getWno()+"\t"+ware.getwName()+"\t"+ware.getwV()+"\t"+ware.getwAddress());
                }
            }else {
                System.out.println("没有符合条件的查询结果！");
            }
            System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
            int i = input.nextInt();
            if (i == 1) {
                new Test().wareMenu();
            }else {
                System.out.println("----------谢谢使用！----------");
                System.exit(1);         //程序正常退出
            }
        } else if (number == 5) {
            new Test().menu();
        } else {
            System.out.println("----------谢谢使用！----------");
            System.exit(1);         //程序正常退出
        }
    }

    public void stockMenu() {
        System.out.println("----------------------------------------------");
        System.out.println("------------------- 库存管理-------------------");
        System.out.println("----------------------------------------------");
        System.out.println("1.添加库存\t2.查询库存\t3.返回上级菜单\t其他：退出程序");
        System.out.println("请输入您的操作序号：");
        int number = input.nextInt();
        if (number == 1) {
            boolean b = stockService.addStock();
            if (b) {
                System.out.println("库存添加成功！");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().stockMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }
        } else if (number == 2) {
            ArrayList list = stockService.queryAllStock();
            for (Object s : list) {
                System.out.println(s);
            }
            System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
            int i = input.nextInt();
            if (i == 1) {
                new Test().stockMenu();
            }else {
                System.out.println("----------谢谢使用！----------");
                System.exit(1);         //程序正常退出
            }
        } else if (number == 3) {
            new Test().menu();
        } else {
            System.out.println("----------谢谢使用！----------");
            System.exit(1);         //程序正常退出
        }
    }


    public void productMenu() {
        System.out.println("----------------------------------------------");
        System.out.println("------------------- 产品管理-------------------");
        System.out.println("----------------------------------------------");
        System.out.println("1.产品入库\t2.产品出库\t3.产品调拨\t4.返回上级菜单\t其他：退出程序");
        System.out.println("请输入您的操作序号：");
        int number = input.nextInt();
        if (number == 1) {
            boolean b = stockService.addProduct();
            if (b) {
                System.out.println("入库成功!");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().productMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }else {
                System.out.println("入库失败!");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().productMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }
        } else if (number == 2) {
            boolean b = stockService.removeProduct();
            if (b) {
                System.out.println("出库成功!");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().productMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }else {
                System.out.println("出库失败!");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().productMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }

        } else if (number == 3) {
            boolean b = stockService.changeProduct();
            if (b) {
                System.out.println("调拨成功!");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().productMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            } else {
                System.out.println("调拨失败!");
                System.out.println("是否要返回上一级菜单？（输入1表示是，其他数字退出程序）");
                int i = input.nextInt();
                if (i == 1) {
                    new Test().productMenu();
                }else {
                    System.out.println("----------谢谢使用！----------");
                    System.exit(1);         //程序正常退出
                }
            }
        } else if (number == 4) {
            new Test().menu();
        } else {
            System.out.println("----------谢谢使用！----------");
            System.exit(1);         //程序正常退出
        }
    }

}
