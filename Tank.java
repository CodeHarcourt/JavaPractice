public class Tank {
    public static void main(String[] args) {
        tank tank1 = new tank();
        tank tank2 = new tank();
        tank1.speedUp(20);
        System.out.println("1号坦克当前速度为" + tank1.speed);
        tank2.speedUp(200);
        System.out.println("2号坦克当前速度为" + tank2.speed);
        tank1.setBulletAmount(10);
        System.out.println("1号坦克子弹数为" + tank1.bulletAmount);
        tank2.setBulletAmount(15);
        System.out.println("2号坦克子弹数为" + tank2.bulletAmount);
        tank1.setColor('Y');
        System.out.println("当前坦克颜色为" + tank.color);
        tank1.fire();
        tank2.conFire(20);
        tank2.setColor('G');
        System.out.println("当前坦克颜色为" + tank.color);
    }

    static class tank {
        double speed;
        int bulletAmount;
        static char color;
        void speedUp(int X) {
            if (X > 200) {
                System.out.println("坦克无法加速到超过200km/h，已达到最大值200km/h");
                X = 200;
            }
            this.speed = X;
        }
        void speedDown(int X) {
            if (X < 0) {
                System.out.println("坦克已停止无法实现减速");
                X = 0;
            }
            this.speed = X;
        }
        void setBulletAmount(int X) {
            if (X < 0) {
                System.out.println("子弹数不能小于0");
                return;
            }
            this.bulletAmount = X;
        }

        double getSpeed() {
            return this.speed;
        }
        int getBulletAmount() {
            return this.bulletAmount;
        }
        void fire() {
            System.out.println("开火1次，发射1枚炮弹");
            System.out.println("当前炮弹数目为：" + (--this.bulletAmount));
//            if(this.bulletAmount == 0) {
//                brake();
//            }
        }
        void conFire(int X) {
            for (int i = 0; i < X; i++) {
                if(this.bulletAmount == 0) {
                    brake();
                    System.out.println("炮弹已打空，tank停止移动");
                    return;
                }
                fire();
            }
        }
        void setColor(char X) {
            color = X;
        }
        void brake() {
            this.speed = 0;
        }
    }
}
