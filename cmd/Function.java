package cmd; 


public sealed interface Function permits LS, WhoAmI, PWD {
  void execute();
}
