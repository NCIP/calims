/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.event;

import java.util.Collection;

import javax.validation.ConstraintViolation;

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
import gov.nih.nci.calims2.domain.inventory.visitor.EventVisitor;

/**
 * @author connollym
 * 
 */
public class EventHierarchyValidator implements EventVisitor {

  @SuppressWarnings("unused")
  private Collection<ConstraintViolation<Event>> violations;

  /**
   * {@inheritDoc}
   */
  public void visitBirthEvent(BirthEvent birthEvent) {
    visitEvent(birthEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitCentrifugationEvent(CentrifugationEvent centrifugationEvent) {
    visitEvent(centrifugationEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitCheckInEvent(CheckInEvent checkInEvent) {
    visitEvent(checkInEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitCheckOutEvent(CheckOutEvent checkOutEvent) {
    visitEvent(checkOutEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitCollectionEvent(CollectionEvent collectionEvent) {
    visitEvent(collectionEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitCollectionProtocolEvent(CollectionProtocolEvent collectionProtocolEvent) {
    visitEvent(collectionProtocolEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitDamageEvent(DamageEvent damageEvent) {
    visitEvent(damageEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitDeathEvent(DeathEvent deathEvent) {
    visitEvent(deathEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitDisposalEvent(DisposalEvent disposalEvent) {
    visitEvent(disposalEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitEmbeddedEvent(EmbeddedEvent embeddedEvent) {
    visitEvent(embeddedEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitEvent(Event event) {
    visitEvent(event);
  }

  /**
   * {@inheritDoc}
   */
  public void visitFeedingEvent(FeedingEvent feedingEvent) {
    visitEvent(feedingEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitFixationEvent(FixationEvent fixationEvent) {
    visitEvent(fixationEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitFreezeEvent(FreezeEvent freezeEvent) {
    visitEvent(freezeEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitHarvestEvent(HarvestEvent harvestEvent) {
    visitEvent(harvestEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitMatingEvent(MatingEvent matingEvent) {
    visitEvent(matingEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitMissingEvent(MissingEvent missingEvent) {
    visitEvent(missingEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitPreservationEvent(PreservationEvent preservationEvent) {
    visitEvent(preservationEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitReceiveEvent(ReceiveEvent receiveEvent) {
    visitEvent(receiveEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitRetireEvent(RetireEvent retireEvent) {
    visitEvent(retireEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitSendEvent(SendEvent sendEvent) {
    visitEvent(sendEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitServiceEvent(ServiceEvent serviceEvent) {
    visitEvent(serviceEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitSterilizationEvent(SterilizationEvent sterilizationEvent) {
    visitEvent(sterilizationEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitThawEvent(ThawEvent thawEvent) {
    visitEvent(thawEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitTransferInEvent(TransferInEvent transferInEvent) {
    visitEvent(transferInEvent);
  }

  /**
   * {@inheritDoc}
   */
  public void visitTransferOutEvent(TransferOutEvent transferOutEvent) {
    visitEvent(transferOutEvent);
  }

  /**
   * The violations to be set.
   * 
   * @param violations the violations to be set.
   */
  public void setViolations(Collection<ConstraintViolation<Event>> violations) {
    this.violations = violations;
  }

}
