package etri.sdn.controller.module.arpmanager;

import java.util.List;
import java.util.Set;

import org.projectfloodlight.openflow.protocol.OFMessage;
import org.projectfloodlight.openflow.protocol.OFPacketIn;
import org.projectfloodlight.openflow.protocol.OFType;

import etri.sdn.controller.MessageContext;
import etri.sdn.controller.OFMFilter;
import etri.sdn.controller.OFModel;
import etri.sdn.controller.OFModule;
import etri.sdn.controller.module.devicemanager.IDevice;
import etri.sdn.controller.module.devicemanager.IDeviceService;
import etri.sdn.controller.protocol.io.Connection;

public class OFMArpManager extends OFModule {

	IDeviceService deviceManager = null;
	
	@Override
	protected void initialize() {
		deviceManager = (IDeviceService) OFModule.getModule(IDeviceService.class);
		
		assert ( deviceManager != null );
		
		registerFilter(OFType.PACKET_IN, new OFMFilter() {

			@Override
			public boolean filter(OFMessage m) {
				OFPacketIn pi = (OFPacketIn) m;
				
				byte[] packet = pi.getData();
				if ( packet[12] == 0x08 && packet[13] == 0x06 ) {
					// ARP! (ethertype)
					return true;
				}
				return false;
			}
			
		});
	}

	@Override
	protected boolean handleHandshakedEvent(Connection conn,
			MessageContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean handleMessage(Connection conn, MessageContext context,
			OFMessage msg, List<OFMessage> outgoing) {
		// PACKET-IN for ARP has arrived.
		Set<Long> swids = this.getController().getSwitchIdentifiers();
		boolean replied = false;
		
		for ( long swid : swids ) {      
			IDevice ret = deviceManager.findDevice(swid, null, null, swid, null);
			if ( ret != null ) {
				// ....
				
				
				// if correctly replied ARP
				replied = true;
				break;
			}
		}
		
		return ! replied;
	}

	@Override
	protected boolean handleDisconnect(Connection conn) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public OFModel[] getModels() {
		// TODO Auto-generated method stub
		return null;
	}

}
