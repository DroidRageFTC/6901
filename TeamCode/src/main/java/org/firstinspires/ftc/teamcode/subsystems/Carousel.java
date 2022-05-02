package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;

import java.util.logging.Level;

@Config
public class Carousel extends SubsystemBase {
    public static double CAROUSEL_LEFT_POWER = -.35;
    public static double CAROUSEL_RIGHT_POWER = .35;

    Telemetry telemetry;
    private MotorEx carouselM;

    public Carousel(HardwareMap hw, Telemetry tl) {
        this.carouselM = new MotorEx(hw, "duck");
        this.telemetry = tl;
    }

    @Override
    public void periodic() {
        Util.logger(this, telemetry, Level.INFO, "Carousel Servo Speed: ", carouselM.get());
    }

    public void set(double power) {carouselM.set(power); }

    public void carouselLeft() {carouselM.set(CAROUSEL_LEFT_POWER);}

    public void carouselRight() {carouselM.set(CAROUSEL_RIGHT_POWER);}

    public void stop() {carouselM.stopMotor();}
}
