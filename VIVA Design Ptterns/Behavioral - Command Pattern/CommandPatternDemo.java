// Command Interface
interface Command {
  void execute();
}

// Receiver
class Light {
  public void on() {
    System.out.println("The light is on");
  }

  public void off() {
    System.out.println("The light is off");
  }
}

// Concrete Command for turning on the light
class LightOnCommand implements Command {
  private Light light;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  public void execute() {
    light.on();
  }
}

// Concrete Command for turning off the light
class LightOffCommand implements Command {
  private Light light;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  public void execute() {
    light.off();
  }
}

// Invoker
class RemoteControl {
  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void pressButton() {
    command.execute();
  }
}

// Usage
public class CommandPatternDemo {
  public static void main(String[] args) {
    Light light = new Light();
    Command lightOn = new LightOnCommand(light);
    Command lightOff = new LightOffCommand(light);

    RemoteControl remote = new RemoteControl();
    remote.setCommand(lightOn);
    remote.pressButton(); // Output: The light is on

    remote.setCommand(lightOff);
    remote.pressButton(); // Output: The light is off
  }
}
