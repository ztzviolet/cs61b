import java.lang.Math;
public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        return Math.sqrt(Math.pow(xxPos-b.xxPos,2)+Math.pow(yyPos-b.yyPos,2));
    }

    public double calcForceExertedBy(Body b){
        return G*mass*b.mass/Math.pow(calcDistance(b),2);
    }

    public double calcForceExertedByX(Body b){
        return calcForceExertedBy(b)*(b.xxPos-xxPos)/calcDistance(b);
    }

    public double calcForceExertedByY(Body b){
        return calcForceExertedBy(b)*(b.yyPos-yyPos)/calcDistance(b);
    }

    public boolean equals(Body b){
        return calcDistance(b)==0;
    }

    public double calcNetForceExertedByX(Body[] allBodys){
        double fx=0;
        for (Body b : allBodys) {
            if (!equals(b)){
                fx += calcForceExertedByX(b);
            }
        }
        return fx;
    }

    public double calcNetForceExertedByY(Body[] allBodys){
        double fy=0;
        for (Body b : allBodys) {
            if (!equals(b)){
                fy += calcForceExertedByY(b);
            }
        }
        return fy;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX/mass;
        double ay = fY/mass;
        xxVel += dt*ax;
        yyVel += dt*ay;
        xxPos += dt*xxVel;
        yyPos += dt*yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
    }

}

