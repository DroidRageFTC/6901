package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.ArmServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class ManualBoxCommand extends SequentialCommandGroup {
    private ArmServos armServos;

    public ManualBoxCommand(ArmServos armServos, Drivetrain drivetrain) {
        addRequirements(armServos, drivetrain);
        addCommands(
//                new InstantCommand(armServos::boxClose, armServos),
                new InstantCommand(armServos::armMid, armServos)
        );
    }
}
