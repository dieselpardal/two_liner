import java.awt.*;

public abstract class TwoLiner {
    int width = 800;
    int height = 600;

    abstract void lines(Graphics graphics, double step);

    public void point(Graphics graphics, double x, double y) {
        graphics.drawLine((int) x, (int) y, (int) x, (int) y);
    }

    double ifn(boolean v) {
        return v ? -1 : 0;
    }
}

class cogumelo2 extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        for (double z = 0; z < 10; z += 0.03) {
            for (double x = 0; x < 10; x += 0.03) {
                double y = -30 * Math.cos(step + 3 * Math.sqrt((x - 5) * (x - 5) + (z - 5) * (z - 5))) / 2 + 50;
                point(graphics, 75 + x * 60 + z * 3, 25 + y + z * 40);
            }
        }
    }
}


class cogumelo3 extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double DU = 3;
        for (double b = 0; b < 128 * DU; b += 1) {
            double x4 = b * b;
            double m = -128 * DU;
            double a = Math.sqrt((128 * DU * 128 * DU) - x4);
            for (double i = -a; i < a; i += 5) {
                double r = Math.sqrt(x4 + i * i + step * 1000) / (128 * DU);
                double f = Math.cos(9 * r) * (1 - r) * 2;
                double y = i / 5 + f * 32 * DU;
                if (!(y <= m)) {
                    m = y;
                    y = 128 * DU + y;
                    point(graphics, 132 * DU + b, 191 * DU * 1.2 - y);
                    point(graphics, 132 * DU - b, 191 * DU * 1.2 - y);
                }
            }
        }
    }
}

class cogumelo4 extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double DU = 3;
        for (double b = 0; b < 128 * DU; b += 1) {
            double x4 = b * b;
            double m = -128 * DU;
            double a = Math.sqrt((128 * DU * 128 * DU) - x4);
            for (double i = -a; i < a; i += 3) {
                double r = Math.sqrt(x4 + i * i) / (128 * DU);
                double f = Math.cos(step * r) * (1 - r) * 2;
                double y = i / 5 + f * 32 * DU;
                if (!(y <= m)) {
                    m = y;
                    point(graphics, 132 * DU + b, 191 * DU * 0.6 - y);
                    point(graphics, 132 * DU - b, 191 * DU * 0.6 - y);
                }
            }
        }
    }
}

class petalas extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double xp, yp, x0 = 0, y0 = 0;
        double pi = 3.141592;
        double q = 2 * pi;
        double n1 = 15;
        double n2 = 12;
        for (double v = 1; v < 10; v += 0.1) {
            double i = v * pi / 30;
            double m1 = n1 * v;
            double m2 = n2 * v;
            for (double f = 0; f < q; f += q / 720) {
                double a = f - i;
                double s = Math.abs(Math.sin(f * step / 2));
                double r = s * m1 + m2;
                double x = Math.cos(a + 0) * r;
                double y = Math.sin(a + 0) * r;
                xp = x * 0.9 + width / 2;
                yp = height / 1.7 - (y * 0.9 + 85);
                if (f == 0) {
                    x0 = xp;
                    y0 = yp;
                } else {
                    graphics.drawLine((int) x0, (int) y0, (int) xp, (int) yp);
                    x0 = xp;
                    y0 = yp;
                }
            }
        }
    }
}

class onda extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        int px = 0, py = 0;
        for (double g = 0; g < 400; g += 5) {
            boolean r = false;
            for (double f = 0; f < 600; f += 5) {
                int x = (int) Math.round(g * 0.5 + f);
                int y = (int) Math.round(75 + g + Math.cos((step * 20 + f) / 30) * Math.cos((20 + g) / 30) * 30);
                if (r) {
                    graphics.drawLine(px, py, x, y);
                } else {

                    r = true;
                }
                px = x;
                py = y;
            }
        }
    }
}

class anemona extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double x0 = 0, y0 = 0;
        double pi = 3.1415926;
        double q = 2 * pi;
        double r = pi / 20;
        double s = pi / 10;
        double t = 60;
        double u = 300 / q;
        for (double b = 0; b < q; b += r) {
            double c = t * pi / 180;
            c = ifn(b > pi) * c - ifn(b <= pi) * c;
            for (double h = 0; h < q; h += s) {
                double y = Math.cos(h + step) * 142;
                double x = Math.cos(b) * h * u;
                double z = -(ifn(Math.sin(b) == 1)) * h * u - ifn(Math.sin(b) != 1) * Math.tan(b) * x;
                z = Math.abs(z);
                z = -1e-03 * ifn(z == 0) - z * ifn(z != 0);
                double j = Math.sqrt(z * z + y * y);
                double a = Math.atan(y / z) + c;
                y = j * Math.sin(a);
                double xp = x * 0.7 + width / 2;
                double yp = y * 0.7 + height / 2;
                x0 = -x0 * ifn(h != 0) - xp * ifn(h == 0);
                y0 = -y0 * ifn(h != 0) - xp * ifn(h == 0);
                graphics.drawLine((int) x0, (int) y0, (int) xp, (int) yp);
                x0 = xp;
                y0 = yp;
            }
        }
    }
}

class batman extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double y;
        double x;
        double px = width / 2;
        double py = height / 2;
        double size = 50;
        double pas = 1/step;
        for (x = -px; x < px; x += pas) {
            y = 1.5 *
                    Math.sqrt(-Math.abs(Math.abs(x) - 1) *
                            Math.abs(3 - Math.abs(x)) / ((Math.abs(x) - 1) *
                            (3 - Math.abs(x)))) *
                    (1 + Math.abs(Math.abs(x) - 3) / (Math.abs(x) - 3)) *
                    Math.sqrt(1 - Math.pow(x / 7, 2)) + (4.5 + 0.75 *
                    (Math.abs(x - 0.5) + Math.abs(x + 0.5)) - 2.75 *
                    (Math.abs(x - 0.75) + Math.abs(x + 0.75))) *
                    (1 + Math.abs(1 - Math.abs(x)) / (1 - Math.abs(x)));

            point(graphics, (int) px + x * size, (int) py - y * size);
        }
        for (x = -px; x < px; x += pas) {
            y =   Math.abs(x / 2) - 0.09137*x*x - 3 +  Math.sqrt(1 -  Math.pow(Math.abs(Math.abs(x) - 2) - 1, 2));
            point(graphics, (int) px + x * size, (int) py - y * size);
        }
        for (x = -px; x < px; x += pas) {
            y = -3*Math.sqrt(1 - Math.pow(x / 7,2))*
                    Math.sqrt(Math.abs(Math.abs(x) - 4) / (Math.abs(x) - 4));
            point(graphics, (int) px + x * size, (int) py - y * size);
        }
        for (x = -px; x < px; x += pas) {
            y =  (2.71052 + 1.5 - 0.5*
                    Math.abs(x) - 1.35526*
                    Math.sqrt(4 - Math.pow(Math.abs(x) - 1,2)))*
            Math.sqrt(Math.abs(Math.abs(x) - 1) / (Math.abs(x) - 1));
            point(graphics, (int) px + x * size, (int) py - y * size);
        }
    }
}
