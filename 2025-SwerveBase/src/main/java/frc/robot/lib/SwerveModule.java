package frc.robot.lib;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class SwerveModule extends SubsystemBase {

    private static String name;

    //Declare Objects up Here!

    private PIDController PID_TURNING;


    private static CANSparkMax driveMotor;
    // Encoder = scary
    private static RelativeEncoder driveEncoder;


    private static CANSparkMax turnMotor;
    // Encoder = scaryier
    private static RelativeEncoder turnEncoder;

    private static SparkPIDController turnPID;

    // Encoder = really scaryier
    private static CANcoder absoluteEncoder;


    /**
     * @param name
     * @param driveID
     * @param turnID
     * @param absoluteEncoderID
     * @param offset
     * @param invertTurn
     * @param invertDrive
     */
    public SwerveModule(
        String name,
        int driveID,
        int turnID,
        int absoluteEncoderID,
        double offset,
        boolean invertTurn,
        boolean invertDrive
    ) {
        // Wasn't sure what to set for encoder so i set as driveID
        driveMotor = new CANSparkMax(driveID, MotorType.kBrushless);
        
        // Resets motor to Factory Settings
        driveMotor.restoreFactoryDefaults();

        // Initializationingzzzzzz. Help...
        // Sets amperage limit to ensure voltage output will not be too-much-ified
        driveMotor.setSmartCurrentLimit(60);
        
        // Sets Motor to be inverted or not (To be or not to be)
        driveMotor.setInverted(invertDrive);

        // Maximum rate the motors controllers output can change
        driveMotor.setClosedLoopRampRate(0.0001);

        // *insert encoder stuff that im scared to touch* 

        // sets PID Vel to the motors PID controller
        turnPID = driveMotor.getPIDController();

        // PID_Config doesn't seem to exist. I gotta fix that
        // .setP sets proportional gain of PID Controller
        // .setI set integral gain of PID Controller
        // .setD set derivative gain of PID Controller
        // just had the realization that PID Config is another thingy and thats why its showing up with an error so technically the issue is not because of me however it will be up to me to fix the issue so i probably should do that so to do that im just going to copy the PID_Config.java because i have something called a skill issue
        // not sure why swerve module is red but lets just role with it. nvm fixed it
        turnPID.setP(PID_Config.SwereModule.ModuleVelocity.Proportional);
        turnPID.setI(PID_Config.SwereModule.ModuleVelocity.Integral);
        turnPID.setD(PID_Config.SwereModule.ModuleVelocity.Derivitive);

        new SimpleMotorFeedforward(
            PID_Config.SwereModule.ModuleVelocity.FeedForward.driveKS,
            PID_Config.SwereModule.ModuleVelocity.FeedForward.driveKV,
            PID_Config.SwereModule.ModuleVelocity.FeedForward.driveKA);

        // Initializes the turning motre and ecodeeeeeee
        turnMotor = new CANSparkMax(turnID, MotorType.kBrushless); 
        // Resets to def
        turnMotor.restoreFactoryDefaults();
        // I keep on forgetting the semi colon :( no bueno
        // Initializationnnnnnnnnnn
        // does same as drive motor but for the turning one
        turnMotor.setSmartCurrentLimit(60);
        turnMotor.setInverted(invertTurn);
        
        // *insert more encoder stuff that im afraid of*

        // tis PID time.
        // Initializing...
        this.PID_TURNING = new PIDController(
        PID_Config.SwereModule.ModuleTurning.Proportional,
        PID_Config.SwereModule.ModuleTurning.Integral,
        PID_Config.SwereModule.ModuleTurning.Derivitive);
        // PID turner does math stuff
        PID_TURNING.enableContinuousInput(-Math.PI, Math.PI);



        // Im not sure if you wanted ModuleDataDashboard bcuz its in a different thingy


    }



    public void setModuleState(SwerveModuleState newState) {
        //Some logic stuff here
        // Not sure if i was supposed to set it to zero but it got rid of the error
        setDriveSpeed(0);
        setTurnAngle(0);
    }

    public void setDriveSpeed(double speed) {}
    
    public void setTurnAngle(double angle) {}

    public void getModuleAngle() {}

}
