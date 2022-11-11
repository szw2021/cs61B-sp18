public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static double G = 6.67 * Math.pow(10, -11);

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double square = Math.pow(xxPos - p.xxPos, 2) + Math.pow(yyPos - p.yyPos, 2);
        return Math.sqrt(square);
    }

    public double calcForceExertedBy(Planet p) {
        return G * mass * p.mass / (Math.pow(calcDistance(p), 2));
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] planetList) {
        double netForce = 0;
        for (Planet planet : planetList) {
            if (planet.equals(this)) {
                continue;
            }
            netForce += calcForceExertedByX(planet);
        }
        return netForce;
    }

    public double calcNetForceExertedByY(Planet[] planetList) {
        double netForce = 0;
        for (Planet planet : planetList) {
            if (planet.equals(this)) {
                continue;
            }
            netForce += calcForceExertedByY(planet);
        }
        return netForce;
    }

    public void update(double dt, double fx, double fy) {
        double FA_X = fx / mass;
        double FA_Y = fy / mass;
        xxVel = xxVel + dt * FA_X;
        yyVel = yyVel + dt * FA_Y;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "./images/" + imgFileName);
    }

}
