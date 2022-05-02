package org.firstinspires.ftc.teamcode.commands.CapArmCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmServos;
import org.firstinspires.ftc.teamcode.subsystems.CapServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class CapArmWarehouseCommand extends SequentialCommandGroup {
    public CapArmWarehouseCommand(ArmServos armServos, Drivetrain drivetrain) {

        addCommands(
                new InstantCommand(armServos::flipperOpen),
                new WaitCommand(200),
                new DriveForwardCommand(drivetrain, 8.5)
        );
    }}

