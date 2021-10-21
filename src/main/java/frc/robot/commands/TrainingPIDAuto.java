package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;

public class TrainingPIDAuto extends SequentialCommandGroup {
    /**
     * Creates a new Autonomous Drive based on distance. This will drive out for a
     * specified distance, turn around and drive back.
     *
     * @param drivetrain The drivetrain subsystem on which this command will run
     */
    public TrainingPIDAuto(Drivetrain drivetrain) {
      addCommands(
       
        new TrainingPIDFoward(drivetrain, 0.4318, 0.0005),
        new TrainingPIDTurn(drivetrain, 90, 2.5),
        new TrainingPIDFoward(drivetrain, 0.4445, 0.0005),
        new TrainingPIDTurn(drivetrain, 90, 2.5),
        new TrainingPIDFoward(drivetrain, 0.4191, 0.0005),
        new TrainingPIDTurn(drivetrain, 90, 2.5),
        new TrainingPIDFoward(drivetrain, 0.2413, 0.0005),
        new TrainingPIDTurn(drivetrain, -90, 2.5),
        new TrainingPIDFoward(drivetrain, 0.2921, 0.0005),
        new TrainingPIDTurn(drivetrain, -90, 2.5),
        new TrainingPIDFoward(drivetrain, 0.4572, 0.0005),
        new TrainingPIDTurn(drivetrain, -90, 2.5),
        new TrainingPIDFoward(drivetrain, 0.4572, 0.0005));
        

      /* Frantic Fetch Cordinates 
      
        //First Ball Is Picked Up Here 
        
        new TrainingPIDFoward(drivetrain, 0.37465 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new TrainingPIDTurn(drivetrain, 90, 3.5),
        new TrainingPIDFoward(drivetrain, 0.2794 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new TrainingPIDFoward(drivetrain, -(0.2794 - (.00635 * 1)), 0.0005),

        //Sets Romi For Second Ball
        new WaitCommand(.75),
        new TrainingPIDTurn(drivetrain, -90, 8),
        new TrainingPIDFoward(drivetrain, 0.18415 - (.00635 * 1), 0.0005),
        new WaitCommand(.75),
        new TrainingPIDTurn(drivetrain, -90, 8),
        new TrainingPIDFoward(drivetrain, 0.2994 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new TrainingPIDTurn(drivetrain, 90, 3.5),
        new TrainingPIDFoward(drivetrain, 0.2794 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new TrainingPIDTurn(drivetrain, 90, 3.5),

        //Grabs the Second Ball and Sets up for Last Ball
        new TrainingPIDFoward(drivetrain, 0.6604 - (.00635 * 1), 0.0005),
        new TrainingPIDFoward(drivetrain, -(0.6604 - (.00635 * 1)), 0.0005),
        new WaitCommand(.75),
        new TrainingPIDTurn(drivetrain, -90, 10),
        
        //Grabs the Last Ball and Sets up for the end circle
        new TrainingPIDFoward(drivetrain, 0.56515 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new TrainingPIDTurn(drivetrain, 90, 3.5),
        new TrainingPIDFoward(drivetrain, 0.6604 - (.00635 * 1), 0.0005),
        new TrainingPIDFoward(drivetrain, -(0.2794 - (.00635 * 1)), 0.0005),
        
        //Gets to the End Circle
        new WaitCommand(.5),
        new TrainingPIDTurn(drivetrain, -90, 8),
        new TrainingPIDFoward(drivetrain, 0.2794 - (.00635 * 1), 0.0005));
      */

    }
}
