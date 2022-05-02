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

    public static double BOX_HOME = -1,
                        BOX_HIGH = 0,
                        BOX_MID = 0,
                        BOX_LOW = 0;

    public static double FLIPPER_OPEN = 0.87;
    public static double FLIPPER_CLOSE = 1;


    private Telemetry telemetry;
    private TelemetryPacket packet;

    private ServoEx armServo;
    private ServoEx flipperServo;

    public ArmServos(ServoEx armServo, ServoEx flipperServo, Telemetry tl, HardwareMap hw) {
        this.armServo = armServo;
        this.flipperServo = flipperServo;

        this.armServo = new SimpleServo(hw,"boxServo", 0, 270);
        this.flipperServo = new SimpleServo(hw,"flipperServo", 0, 270);

        this.telemetry = tl;
        this.packet = packet;

        this.armServo.setPosition(BOX_HOME);
        this.flipperServo.setPosition(FLIPPER_OPEN);
    }
    @Override
    public void periodic() {
        Util.logger(this, telemetry, Level.INFO, "Arm Servo Position: ", armServo.getPosition());
        Util.logger(this, telemetry, Level.INFO, "Drop Servo Position: ", flipperServo.getPosition());
    }

    public void setArmServo(double armServoPosition) {
        armServo.setPosition(armServoPosition);}
    public void setDropServo(double dropServoPosition){
        flipperServo.setPosition(dropServoPosition);}


    public void armLow() {
        setArmServo(BOX_LOW);
    }
    public void armHigh() {
        setArmServo(BOX_HIGH);
    }
    public void armMid() {
        setArmServo(BOX_MID);
    }
    public void flipperOpen() {
        setDropServo(FLIPPER_OPEN);
    }
    public void flipperClose() {
        setDropServo(FLIPPER_CLOSE);
    }

    public void boxUp() { setDropServo(flipperServo.getPosition()+0.1); }
    public void boxDown() { setDropServo(flipperServo.getPosition()-0.1); }


    public void reset()
    {
        setArmServo(BOX_HOME);
        setDropServo(FLIPPER_OPEN);
    }
}