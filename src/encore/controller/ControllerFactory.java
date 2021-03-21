package encore.controller;

public class ControllerFactory {
	
	private static ControllerFactory Factory = new ControllerFactory();
	private ControllerFactory () {}
	public static ControllerFactory getInstance() {
		return Factory;
	}
	
	public Controller createController(String command) {
		
		Controller controller= null;
	
		//String path = "index.jsp";
		
		if(command.equals("find")) {
			//command 값을 주고 controller type 으로 받는다  (재사용성!!! 위해서_controller를 구현한 실제적인 component가 자동. component.execute()로 일일이X)
			controller = new FindController();  // 받는 command 값에 따라서 만드는 component 를 만든다   그 후 만든 component 자체가 아니라 controller 로 타입으로 던짐(인터페이스타입)
		}else if(command.equals("login")){
			controller = new LoginController();
		}else if(command.equals("allmember")) {
			controller = new AllMemberController();
		}else if(command.equals("logout")) {
			controller = new LogoutController();
		}else if(command.equals("update")) {
			controller = new UpdateController();
		}else if(command.equals("register")) {
			controller = new RegisterController();
		}else if(command.equals("idcheck")) {
			controller = new IdCheckController();
		}
		
		return controller;
	}	

}
