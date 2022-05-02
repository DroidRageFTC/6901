package org.firstinspires.ftc.teamcode.commands.IntakeCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.ArmServos;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class ColorIntakeCommand extends SequentialCommandGroup {

    public ColorIntakeCommand(Intake intake,  ArmServos armServos) {
        addRequirements(intake,armServos);
        addCommands(

                        new SequentialCommandGroup(
                                new InstantCommand(armServos::armLow),
//                                new InstantCommand(armServos::boxClose),
                                new InstantCommand(intake::stop),
                                new WaitCommand(500),
                                new InstantCommand(armServos::armMid))

//                        new InstantCommand(),
//                        () -> (colorSensor.freightInBox())

        );
    }
}