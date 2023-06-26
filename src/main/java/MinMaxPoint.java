public class MinMaxPoint {
    MinMaxInt x;
    MinMaxInt y;
    MinMaxPoint(int xin, int xmax, int yin, int ymax) {
        x = new MinMaxInt(xin,0,xmax,false);
        y = new MinMaxInt(yin,0,ymax,false);
    }
}
