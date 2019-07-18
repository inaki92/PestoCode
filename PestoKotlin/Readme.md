Restaurants have expressed a desire for the tablet to visually notify the staff in certain cases:

1. Customer wants to summon the server (flashing red light, only turns off when the
    user forces it off)
2. Payment successful, not requesting receipt (solid green light, turns off after 3 minutes or
    user turns it off)
3. Payment successful, requesting receipt (flashing green light, turns off after 3 minutes or
    user turns it off)
4. Customer is starting to pay. (solid orange light, turns off when calling code turns it off or
    2 minutes(whichever comes first).)

In order to accomplish the requirements listed above I implemented a class called FlashingLed,
this class is implementing Runnable(), which allows you to run in a thread a certain portion of code, in
this case I override the method run() to make the 1 second flashing light.

In the class FlashingLogicManager, I implemented the logic for turning on and turning off the LED, in this
class I used handlers in order to send messages to the thread and be aware of what is happening with the LED.
With handlers we can use the postDelay() in order to wait certain amount of time before post the message to the
thread.

turningOnLED(). This method is in charge of setting the LED color and then check if we need to display
a solid or flashing LED, using the handler to post the values of brightness.

turningOffLED(). This method will send a message CANCEL to the thread using the handler in order to turn
off the LED and reset the UI.

onReset(). This method is used to reset the UI, delete all the call backs in the handler and set the
LED brightness to zero.

The way it was implemented is useful to add more use cases with little refactoring work since we are
using handlers and runnable to execute each case pointed by the needs.
