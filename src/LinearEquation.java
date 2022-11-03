import java.text.DecimalFormat;
public class LinearEquation {
    DecimalFormat to100 = new DecimalFormat("#.##");
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    public LinearEquation(int x12, int y12, int x22, int y22 ) {
        x1 = x12;
        y1 = y12;
        x2 = x22;
        y2 = y22;
    }
    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
  this precondition is not violated)
public LinearEquation(int x1, int y1, int x2, int y2)


/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
  the nearest hundredth */
    public double distance() {
        return roundedToHundredth(Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
    }



    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept() {
        return roundedToHundredth(y1 - ((double)(y2 - y1) / (x2 - x1)) * (x1));

    }



    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        if (roundedToHundredth(((double) y2 - (double) y1)/( (double) x2 - (double) x1))==-0.0) {
            return 0.0;
        }
        return roundedToHundredth(((double) y2 - (double) y1)/( (double) x2 - (double) x1));
    }



    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0   - 2.35       + 12.5      - 8.0     + 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0  + -2.35    - -12.5    + -8.0      - -17.19  + 0    - 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation() {
        double y;
        double x;
        String neg;
        if ((((double) x2 - (double) x1) > 0 && ((double) y2 - (double) y1) > 0) || (((double) x2 - (double) x1) < 0 && ((double) y2 - (double) y1) < 0)) {
            neg = "";
        } else {
            neg = "-";
        }
        String interSym = "+";
        if (yIntercept() < 0){
            interSym = "";
        }
        /* marker */ if (yIntercept()==0){
            if (Math.abs((y2-y1))/(double)Math.abs((x2-x1))==1){
                return "y="+neg+ " "+"x "+ interSym+yIntercept();
            }
            if (Math.abs((y2-y1))/(double)Math.abs((x2-x1))==(int)(Math.abs((y2-y1))/(double)Math.abs((x2-x1)))){
                return "y="+neg+ " "+(int)Math.abs((y2-y1))/(int)Math.abs((x2-x1))+"x "+ interSym+yIntercept();
            }

            return "y="+neg+ " "+(int)Math.abs((y2-y1))+"/"+(int)Math.abs((x2-x1))+"x "+ interSym+yIntercept();
        }
        if (Math.abs((y2-y1))/(double)Math.abs((x2-x1))==1){
            return "y="+neg+ " "+"x "+ interSym+yIntercept();
        }
        if (Math.abs((y2-y1))/(double)Math.abs((x2-x1))==(int)(Math.abs((y2-y1))/(double)Math.abs((x2-x1)))){
            return "y="+neg+ " "+(int)Math.abs((y2-y1))/(int)Math.abs((x2-x1))+"x "+ interSym+yIntercept();
        }

        return "y="+neg+ " "+(int)Math.abs((y2-y1))+"/"+(int)Math.abs((x2-x1))+"x "+ interSym+yIntercept();
    }





    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        double yValue = roundedToHundredth(xValue * slope()+yIntercept());
        xValue = roundedToHundredth(xValue);
        return "("+xValue+", "+yValue+")";
    }





    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound) {
        return Double.parseDouble(to100.format(toRound));
    }



    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo() {
        return "The two points are: ("+ x1+", "+y1+") "+"("+x2+", "+y2+") \n"
                + "The equation of the line between these points is: "+ equation()+"\n"
                + "The slope of this line is: "+ slope()+"\n"
                + "The y-intercept of the line is: "+ yIntercept()+"\n"
                + "The distance between the two points is: "+ distance()+"\n";
    }










}