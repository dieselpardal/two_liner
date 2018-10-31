import java.awt.*;

abstract class TwoLiner {
    double width = 0;
    double height = 0;

    abstract void lines(Graphics graphics, double step);

    void setSize(Graphics graphics, int width, int height) {
        this.width = width;
        this.height = height;
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.black);
    }

    void point(Graphics graphics, double x, double y) {
        graphics.drawLine((int) x, (int) y, (int) x, (int) y);
    }

    void line(Graphics graphics, double x1, double y1, double x2, double y2) {
        graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }

    double ifn(boolean v) {
        return v ? -1 : 0;
    }


}

class cogumelo1 extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double sizex = this.width / 266;
        double sizey = this.height / 266;
        for (double z = -5; z < 5; z += 0.03) {
            for (double x = -5; x < 5; x += 0.03) {
                double y = -(Math.cos(-step / 10 + 3 * Math.sqrt(x * x + z * z))) * 5;
                point(graphics, this.width / 2 + (x * 24 + z) * sizex, this.height / 2 - (y - z * 10) * sizey);
            }
        }
    }
}

class cogumelo2 extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double sizex = this.width / 800;
        double sizey = this.height / 600;
        for (double z = -5; z < 5; z += 0.03) {
            for (double x = -5; x < 5; x += 0.03) {
                double y = -30 * Math.cos(step / 10 + 3 * Math.sqrt(x * x + z * z)) / 2;
                point(graphics, this.width / 2 + (x * 60 + z * 3) * sizex, this.height / 2 + (y + z * 40) * sizey);
            }
        }
    }
}


class cogumelo3 extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double px = this.width / 2;
        double py = this.height / 2;
        for (double b = 0; b < px; b += 1) {
            double x4 = b * b;
            double m = -px;
            double a = Math.sqrt(px * px - x4);
            for (double i = -a; i < a; i += 5) {
                double r = Math.sqrt(x4 + i * i + step * 1000) / px;
                double f = Math.cos(9 * r) * (1 - r) * 2;
                double y = i / 5 + f * px / 4;
                if (!(y <= m)) {
                    m = y;
                    point(graphics, px + b, py - y);
                    point(graphics, px - b, py - y);
                }
            }
        }
    }
}

class cogumelo4 extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double px = this.width / 2;
        double py = this.height / 2;
        for (double b = 0; b < px; b += 1) {
            double x4 = b * b;
            double m = -px;
            double a = Math.sqrt((px * px) - x4);
            for (double i = -a; i < a; i += 3) {
                double r = Math.sqrt(x4 + i * i) / px;
                double f = Math.cos(step / 5 * r) * (1 - r) * 2;
                double y = i / 5 + f * px / 4;
                if (!(y <= m)) {
                    m = y;
                    point(graphics, px + b, py * 1.3 - y);
                    point(graphics, px - b, py * 1.3 - y);
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
        double sizex = this.width / 800;
        double sizey = this.height / 600;
        for (double v = 1; v < 10; v += 0.1) {
            double i = v * pi / 30;
            double m1 = n1 * v;
            double m2 = n2 * v;
            for (double f = 0; f < q; f += q / 720) {
                double a = f - i;
                double s = Math.abs(Math.sin(f * step / 20));
                double r = s * m1 + m2;
                double x = Math.cos(a + 0) * r;
                double y = Math.sin(a + 0) * r;
                xp = x * sizex + this.width / 2;
                yp = this.height / 1.7 - ((y + 50) * sizey);
                if (f == 0) {
                    x0 = xp;
                    y0 = yp;
                } else {
                    line(graphics, x0, y0, xp, yp);
                    x0 = xp;
                    y0 = yp;
                }
            }
        }
    }
}

class onda extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double px = 0, py = 0;
        for (double g = 0; g < this.height; g += 5) {
            boolean r = false;
            for (double f = 0; f < this.width * 2; f += 5) {
                double x = Math.round(g * 0.5 + f);
                double y = Math.round(g + Math.cos((step / 5 * 20 + f) / 30) * Math.cos((20 + g) / 30) * 30);
                if (r) {
                    line(graphics, px - this.width / 2, py, x - this.width / 2, y);
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
        double sizex = this.width / 800;
        double sizey = this.height / 600;
        for (double b = 0; b < q; b += r) {
            double c = t * pi / 180;
            c = ifn(b > pi) * c - ifn(b <= pi) * c;
            for (double h = 0; h < q; h += s) {
                double y = Math.cos(h + step / 5) * 142;
                double x = Math.cos(b) * h * u;
                double z = -(ifn(Math.sin(b) == 1)) * h * u - ifn(Math.sin(b) != 1) * Math.tan(b) * x;
                z = Math.abs(z);
                z = -1e-03 * ifn(z == 0) - z * ifn(z != 0);
                double j = Math.sqrt(z * z + y * y);
                double a = Math.atan(y / z) + c;
                y = j * Math.sin(a);
                double xp = x * sizex + this.width / 2;
                double yp = y * sizey + this.height / 2;
                x0 = -x0 * ifn(h != 0) - xp * ifn(h == 0);
                y0 = -y0 * ifn(h != 0) - xp * ifn(h == 0);
                line(graphics, x0, y0, xp, yp);
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
        double px = this.width / 2;
        double py = this.height / 2;
        double sizex = this.width / 16;
        double sizey = this.height / 12;
        double pas = 1 / step / 10;
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

            point(graphics, (int) px + x * sizex, (int) py - y * sizey);
        }
        for (x = -px; x < px; x += pas) {
            y = Math.abs(x / 2) - 0.09137 * x * x - 3 + Math.sqrt(1 - Math.pow(Math.abs(Math.abs(x) - 2) - 1, 2));
            point(graphics, (int) px + x * sizex, (int) py - y * sizey);
        }
        for (x = -px; x < px; x += pas) {
            y = -3 * Math.sqrt(1 - Math.pow(x / 7, 2)) *
                    Math.sqrt(Math.abs(Math.abs(x) - 4) / (Math.abs(x) - 4));
            point(graphics, (int) px + x * sizex, (int) py - y * sizey);
        }
        for (x = -px; x < px; x += pas) {
            y = (2.71052 + 1.5 - 0.5 *
                    Math.abs(x) - 1.35526 *
                    Math.sqrt(4 - Math.pow(Math.abs(x) - 1, 2))) *
                    Math.sqrt(Math.abs(Math.abs(x) - 1) / (Math.abs(x) - 1));
            point(graphics, (int) px + x * sizex, (int) py - y * sizey);
        }

    }
}

class Astroide1 extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double px = this.width / 2;
        double py = this.height / 2;
        for (double f = 0; f <= px; f += 10) {
            double g = py - f * (py - step * 2) / (px - step * 2);
            line(graphics, f, py, px, g);
            line(graphics, px, g, this.width - f, py);
            line(graphics, f, py, px, this.height - g);
            line(graphics, px, this.height - g, this.width - f, py);
        }

    }
}

class Astroide2 extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double px = this.width / 2;
        double py = this.height / 2;
        double pi = 3.1415926;
        for (double a = 10; a <= py + 15; a += 15) {
            double u = a;
            double v = 0;
            for (double t = 0; t <= pi / 2; t += 0.2) {
                double x = a * (Math.pow(Math.cos(t), step / 10));
                double y = a * ((Math.pow(Math.sin(t), step / 10)));
                line(graphics, px + u, py + v, px + x, py + y);
                line(graphics, px + u, py - v, px + x, py - y);
                line(graphics, px - u, py + v, px - x, py + y);
                line(graphics, px - u, py - v, px - x, py - y);
                u = x;
                v = y;
                if (a >= Math.round(py)) {
                    line(graphics, px, py, px + x, py + y);
                    line(graphics, px, py, px + x, py - y);
                    line(graphics, px, py, px - x, py + y);
                    line(graphics, px, py, px - x, py - y);
                }
            }
        }
    }
}

class Tekening extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double f1 = Math.random();
        double f2 = Math.random();
        double f3 = Math.random();
        double v1 = Math.random();
        double v2 = Math.random();

        for (double i = 0; i <= 12.6; i += 0.02 + Math.random()) {
            double x1 = 20 * i;
            double y1 = (Math.sin(i * 2 * f1) + 1) * (this.height / 2) * v1;
            double x2 = (Math.cos(i * 2 * f2 + f3 * 6.3) + 1) * (this.width / 2) * v2;
            double y2 = 16 * i;
            line(graphics, x1, y1, x2, y2);
        }
    }
}

class Spirograph extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double r1 = Math.sin(step / 100);
        double r2 = Math.cos((100 - step) / 10) / 10;
        double r3 = 1;
        double fx = (this.width / 3) / (r1 + r2 + r3);
        double fy = (this.height / 3) / (r1 + r2 + r3);
        double mx = 0, my = 0;
        int m = 0;
        for (double t = 0; t <= 1000; t += 0.4) {
            double x = fx * (Math.cos(t) * r3 + Math.cos(t * r2 / r1) * (r1 + r2)) + (this.width / 2);
            double y = fy * (Math.sin(t) * r3 + Math.sin(t * r2 / r1) * (r1 + r2)) + (this.height / 2);
            if (m == 1) {
                line(graphics, x, y, mx, my);
            }
            m = 1;
            mx = x;
            my = y;
        }
    }
}

class Cruz extends TwoLiner {
    public void lines(Graphics graphics, double step) {
        double px = this.width / 2;
        double py = this.height / 2;
        line(graphics, 0, py, this.width, py);
        line(graphics, px, this.height, px, 0);

    }
}
