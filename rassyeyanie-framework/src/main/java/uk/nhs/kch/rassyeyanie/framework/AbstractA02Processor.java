package uk.nhs.kch.rassyeyanie.framework;

import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.v24.message.ADT_A02;
import ca.uhn.hl7v2.model.v24.segment.DB1;
import ca.uhn.hl7v2.model.v24.segment.EVN;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.OBX;
import ca.uhn.hl7v2.model.v24.segment.PD1;
import ca.uhn.hl7v2.model.v24.segment.PDA;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v24.segment.PV1;
import ca.uhn.hl7v2.model.v24.segment.PV2;
import ca.uhn.hl7v2.model.v24.segment.ROL;

@Deprecated
public class AbstractA02Processor extends AbstractProcessor {
	public void transform(PDA pda, PDA clonaedPda) throws HL7Exception {
	}

	public void transformRols(List<ROL> rols) throws HL7Exception {
	}

	public void transformDb1s(List<DB1> db1s) throws HL7Exception {
	}

	public void transformObxs(List<OBX> obxs) throws HL7Exception {
	}

	public void transform(EVN evn, EVN clonedEvn) throws HL7Exception {

	}

	public void transform(MSH msh, MSH clonedMsh) throws HL7Exception {

	}

	public void transform(PD1 pd1, PD1 clonedPd1) throws HL7Exception {

	}

	public void transform(PID pid, PID clonedPid) throws HL7Exception {

	}

	public void transform(PV1 pv1, PV1 clonedPv1) throws HL7Exception {

	}

	public void transform(PV2 pv2, PV2 clonedPv2) throws HL7Exception {

	}

	@Override
	protected void dispatchProcessFixture(AbstractMessage workingMessage)
			throws HL7Exception {
		ADT_A02 message = (ADT_A02) workingMessage;
		ADT_A02 clonedMessage = new ADT_A02();

		this.transform(message.getEVN(),
				this.copySegment(message.getEVN(), clonedMessage.getEVN()));
		this.transform(message.getMSH(),
				this.copySegment(message.getMSH(), clonedMessage.getMSH()));
		this.transform(message.getPD1(),
				this.copySegment(message.getPD1(), clonedMessage.getPD1()));
		this.transform(message.getPDA(),
				this.copySegment(message.getPDA(), clonedMessage.getPDA()));
		this.transform(message.getPID(),
				this.copySegment(message.getPID(), clonedMessage.getPID()));
		this.transform(message.getPV1(),
				this.copySegment(message.getPV1(), clonedMessage.getPV1()));
		this.transform(message.getPV2(),
				this.copySegment(message.getPV2(), clonedMessage.getPV2()));

		this.transformDb1s(HapiUtil.getAll(workingMessage, DB1.class));
		this.transformObxs(HapiUtil.getAll(workingMessage, OBX.class));
		this.transformRols(HapiUtil.getAll(workingMessage, ROL.class));
	}
}
