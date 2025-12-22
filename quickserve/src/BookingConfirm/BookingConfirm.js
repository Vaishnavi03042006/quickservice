import React, { useState } from "react";
import "./BookingConfirm.css";

export default function BookingConfirm() {
  const [message, setMessage] = useState("");
  const [type, setType] = useState("");

  const handleConfirm = () => {
    setType("success");
    setMessage("🎉 Your booking has been confirmed successfully!");
  };

  const handleCancel = () => {
    setType("cancel");
    setMessage("❌ Booking cancelled. You can continue browsing services.");
  };

  return (
    <div className="booking-page">
      {/* Header */}
      <div className="booking-header">
        <span className="back-btn">← Back</span>
        <h2 className="main-title">Confirm Your Booking</h2>
        <p className="subtitle">Please review the details before confirming</p>
      </div>

      {/* Reservation Info */}
      <div className="reservation-info">
        <span className="dot"></span>
        <span>This slot is temporarily reserved for you</span>
        <span className="time">Time Remaining: 0:00</span>
      </div>

      {/* Booking Card */}
      <div className="booking-card">
        <h3 className="service-title">Deep Cleaning Service</h3>

        <div className="detail-row">
          <span className="label">Provider</span>
          <span className="value">Sarah Johnson</span>
        </div>

        <div className="date-box">
          <span className="label">Date & Time</span>
          <p>Monday, December 23, 2024</p>
          <p>2:00 PM – 4:00 PM</p>
        </div>

        <div className="detail-row">
          <span className="label">Location</span>
          <span className="value">
            123 Main Street, Apt 4B, New York, NY 10001
          </span>
        </div>

        <div className="detail-row">
          <span className="label">Duration</span>
          <span className="value">2 hours</span>
        </div>

        <hr />

        <div className="price-section">
          <p className="section-title">Price Breakdown</p>

          <div className="price-row">
            <span>Service price</span>
            <span>$89.99</span>
          </div>

          <div className="price-row">
            <span>Service fee</span>
            <span>$5.00</span>
          </div>

          <div className="price-row">
            <span>Taxes & fees</span>
            <span>$7.20</span>
          </div>

          <div className="price-total">
            <span>Total</span>
            <span>$102.19</span>
          </div>
        </div>

        <div className="action-buttons">
          <button className="cancel-btn" onClick={handleCancel}>
            Cancel
          </button>
          <button className="confirm-btn" onClick={handleConfirm}>
            Confirm Booking
          </button>
        </div>
      </div>

      {/* Message Popup */}
      {message && (
        <div className={`message-popup ${type}`}>
          {message}
        </div>
      )}
    </div>
  );
}
