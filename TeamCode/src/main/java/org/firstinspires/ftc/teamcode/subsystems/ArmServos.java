package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;

import java.util.logging.Level;

@Config
public class ArmServos extends SubsystemBase {

    public static double SERVO_POSITION_ARM_HOME = -1;

    public static double BOX_SHARED = 0.3;
    public static double BOX_HIGH = 0.8;
    public static double BOX_DOWN = -1;
//    public static double SERVO_POSITION_ARM_DROP = 0.9;
//    public static double SERVO_POSITION_ARM_SHARED = .9;
//
    public static double FLIPPER_OPEN = 0.87;
//    public static double SERVO_POSITION_BOX_AUTO_PUSH = 0.1;
//    public static double SERVO_POSITION_BOX_PUSH = 0;
    public static double FLIPPER_CLOSE = 1;

    public static double SERVO_POSITION_BOX_CLOSE_BALL = 0.7;
    public static double SERVO_POSITION_BOX_CLOSE_CUBE = 0.8;

//    public static boolean boxCanMove;
//    public static boolean freightInBox;

    private Telemetry telemetry;
    private TelemetryPacket packet;

    private ServoEx armServo;
    private ServoEx dropServo;

    public ArmServos(ServoEx armServo, ServoEx dropServo, Telemetry tl, HardwareMap hw) {
        this.armServo = armServo;
        this.dropServo = dropServo;

        this.armServo = new SimpleServo(hw,"boxServo", 0, 270);
        this.dropServo = new SimpleServo(hw,"flipperServo", 0, 270);

        this.telemetry = tl;
        this.packet = packet;

        this.armServo.setPosition(SERVO_POSITION_ARM_HOME);
        this.dropServo.setPosition(FLIPPER_OPEN);
    }
    @Override
    public void periodic() {
        Util.logger(this, telemetry, Level.INFO, "Arm Servo Position: ", armServo.getPosition());
        Util.logger(this, telemetry, Level.INFO, "Drop Servo Position: ", dropServo.getPosition());
    }

    public void setArmServo(double armServoPosition) {
        armServo.setPosition(armServoPosition);}
    public void setDropServo(double dropServoPosition){
        dropServo.setPosition(dropServoPosition);}

    public void armHome() {
        setArmServo(SERVO_POSITION_ARM_HOME);
    }
    public void armShared() {
        setArmServo(BOX_SHARED);
    }
//    public void armDrop() {
//        setArmServo(SERVO_POSITION_ARM_DROP);
//    }
    public void armHalfDrop() {
        setArmServo(BOX_DOWN);
    }

    public void armAutoDrop() {
        setArmServo(BOX_HIGH);
    }

//    public void armShared() {
//        setArmServo(SERVO_POSITION_ARM_SHARED);
//    }

    public void boxOpen() { setDropServo(FLIPPER_OPEN); }
    public void boxClose() { setDropServo(FLIPPER_CLOSE); }
    public void boxPush() {  }
    public void boxAutoPush() { }

//    public void boxBall() { setDropServo(SERVO_POSITION_BOX_CLOSE_BALL); }
//    public void boxCube() { setDropServo(SERVO_POSITION_BOX_CLOSE_CUBE); }

    public void boxUp() { setDropServo(dropServo.getPosition()+0.1); }
    public void boxDown() { setDropServo(dropServo.getPosition()-0.1); }


    public void reset()
    {
        setArmServo(SERVO_POSITION_ARM_HOME);
        setDropServo(FLIPPER_OPEN);
    }
}