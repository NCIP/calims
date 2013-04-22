/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.inventory.visitor;

import gov.nih.nci.calims2.domain.inventory.event.BirthEvent;
import gov.nih.nci.calims2.domain.inventory.event.CentrifugationEvent;
import gov.nih.nci.calims2.domain.inventory.event.CheckInEvent;
import gov.nih.nci.calims2.domain.inventory.event.CheckOutEvent;
import gov.nih.nci.calims2.domain.inventory.event.CollectionEvent;
import gov.nih.nci.calims2.domain.inventory.event.CollectionProtocolEvent;
import gov.nih.nci.calims2.domain.inventory.event.DamageEvent;
import gov.nih.nci.calims2.domain.inventory.event.DeathEvent;
import gov.nih.nci.calims2.domain.inventory.event.DisposalEvent;
import gov.nih.nci.calims2.domain.inventory.event.EmbeddedEvent;
import gov.nih.nci.calims2.domain.inventory.event.Event;
import gov.nih.nci.calims2.domain.inventory.event.FeedingEvent;
import gov.nih.nci.calims2.domain.inventory.event.FixationEvent;
import gov.nih.nci.calims2.domain.inventory.event.FreezeEvent;
import gov.nih.nci.calims2.domain.inventory.event.HarvestEvent;
import gov.nih.nci.calims2.domain.inventory.event.MatingEvent;
import gov.nih.nci.calims2.domain.inventory.event.MissingEvent;
import gov.nih.nci.calims2.domain.inventory.event.PreservationEvent;
import gov.nih.nci.calims2.domain.inventory.event.ReceiveEvent;
import gov.nih.nci.calims2.domain.inventory.event.RetireEvent;
import gov.nih.nci.calims2.domain.inventory.event.SendEvent;
import gov.nih.nci.calims2.domain.inventory.event.ServiceEvent;
import gov.nih.nci.calims2.domain.inventory.event.SterilizationEvent;
import gov.nih.nci.calims2.domain.inventory.event.ThawEvent;
import gov.nih.nci.calims2.domain.inventory.event.TransferInEvent;
import gov.nih.nci.calims2.domain.inventory.event.TransferOutEvent;

/**
 * @author connollym
 *
 */
public interface EventVisitor {

  /**
   * @param birthEvent
   */
  void visitBirthEvent(BirthEvent birthEvent);

  /**
   * @param centrifugationEvent
   */
  void visitCentrifugationEvent(CentrifugationEvent centrifugationEvent);

  /**
   * @param checkInEvent
   */
  void visitCheckInEvent(CheckInEvent checkInEvent);

  /**
   * @param checkOutEvent
   */
  void visitCheckOutEvent(CheckOutEvent checkOutEvent);

  /**
   * @param collectionEvent
   */
  void visitCollectionEvent(CollectionEvent collectionEvent);

  /**
   * @param collectionProtocolEvent
   */
  void visitCollectionProtocolEvent(CollectionProtocolEvent collectionProtocolEvent);

  /**
   * @param damageEvent
   */
  void visitDamageEvent(DamageEvent damageEvent);

  /**
   * @param deathEvent
   */
  void visitDeathEvent(DeathEvent deathEvent);

  /**
   * @param disposalEvent
   */
  void visitDisposalEvent(DisposalEvent disposalEvent);

  /**
   * @param embeddedEvent
   */
  void visitEmbeddedEvent(EmbeddedEvent embeddedEvent);

  /**
   * @param event
   */
  void visitEvent(Event event);

  /**
   * @param feedingEvent
   */
  void visitFeedingEvent(FeedingEvent feedingEvent);

  /**
   * @param fixationEvent
   */
  void visitFixationEvent(FixationEvent fixationEvent);

  /**
   * @param freezeEvent
   */
  void visitFreezeEvent(FreezeEvent freezeEvent);

  /**
   * @param harvestEvent
   */
  void visitHarvestEvent(HarvestEvent harvestEvent);

  /**
   * @param matingEvent
   */
  void visitMatingEvent(MatingEvent matingEvent);

  /**
   * @param missingEvent
   */
  void visitMissingEvent(MissingEvent missingEvent);

  /**
   * @param preservationEvent
   */
  void visitPreservationEvent(PreservationEvent preservationEvent);

  /**
   * @param receiveEvent
   */
  void visitReceiveEvent(ReceiveEvent receiveEvent);

  /**
   * @param retireEvent
   */
  void visitRetireEvent(RetireEvent retireEvent);

  /**
   * @param sendEvent
   */
  void visitSendEvent(SendEvent sendEvent);

  /**
   * @param serviceEvent
   */
  void visitServiceEvent(ServiceEvent serviceEvent);

  /**
   * @param sterilizationEvent
   */
  void visitSterilizationEvent(SterilizationEvent sterilizationEvent);

  /**
   * @param thawEvent
   */
  void visitThawEvent(ThawEvent thawEvent);

  /**
   * @param transferInEvent
   */
  void visitTransferInEvent(TransferInEvent transferInEvent);

  /**
   * @param transferOutEvent
   */
  void visitTransferOutEvent(TransferOutEvent transferOutEvent);

}
