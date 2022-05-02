package org.firstinspires.ftc.teamcode.commands.IntakeCommands;

import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class AutoIntakeCommand extends SequentialCommandGroup {

    public AutoIntakeCommand(Lift lift, Intake intake, ArmServos armServos, Drivetrain drivetrain) {
        addRequirements(lift, intake, armServos, drivetrain);
        addCommands(
                        new SequentialCommandGroup(
                                new InstantCommand(armServos::boxClose),
                                new InstantCommand(armServos::armAutoDrop),
                                new InstantCommand(intake::outtake),
                                new DriveForwardCommand(drivetrain, -2)
                        ),
                        new SequentialCommandGroup(
                                new DriveForwardCommand(drivetrain,5),
                                //new WaitCommand(100),
                                new InstantCommand(armServos::boxClose),
                                new InstantCommand(armServos::armAutoDrop),
                                new InstantCommand(intake::outtake),
                                new DriveForwardCommand(drivetrain, -6)
                ),
                new InstantCommand(armServos::boxClose));

    }
}