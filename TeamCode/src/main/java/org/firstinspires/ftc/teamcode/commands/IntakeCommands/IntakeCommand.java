package org.firstinspires.ftc.teamcode.commands.IntakeCommands;


        import com.arcrobotics.ftclib.command.InstantCommand;
        import com.arcrobotics.ftclib.command.SequentialCommandGroup;
        import com.arcrobotics.ftclib.command.WaitCommand;

        import org.firstinspires.ftc.teamcode.subsystems.ArmServos;
        import org.firstinspires.ftc.teamcode.subsystems.Intake;
        import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class IntakeCommand extends SequentialCommandGroup {

    public IntakeCommand(Lift lift, Intake intake, ArmServos armServos) {
        addRequirements(lift, intake, armServos);
        addCommands(
                new InstantCommand(intake::intake, intake),
                new InstantCommand(intake::stop),
                new InstantCommand(intake::outtake, intake),
                new WaitCommand(500),
                new InstantCommand(intake::stop, intake),
                new InstantCommand(intake::servoUp,intake)

        );
    }
}