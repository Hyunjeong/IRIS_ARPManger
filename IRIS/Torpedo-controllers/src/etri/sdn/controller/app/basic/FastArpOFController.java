package etri.sdn.controller.app.basic;

import org.projectfloodlight.openflow.protocol.OFMessage;

import etri.sdn.controller.MessageContext;
import etri.sdn.controller.OFController;
import etri.sdn.controller.protocol.io.Connection;

public class FastArpOFController extends OFController {

	public FastArpOFController(int num_of_queue, String role) {
		super(num_of_queue, role);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean handlePacketIn(Connection conn, MessageContext context,
			OFMessage m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleGeneric(Connection conn, MessageContext context,
			OFMessage m) {
		// TODO Auto-generated method stub
		return false;
	}

}
