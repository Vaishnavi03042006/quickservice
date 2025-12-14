import React, { useState } from "react";

export default function ServiceDetails() {
  const [showPopup, setShowPopup] = useState(false);

  return (
    <>
      {/* ================= CSS ================= */}
      <style>{`
        body {
          margin: 0;
          font-family: "Segoe UI", Arial, sans-serif;
        }

        .service-page {
          background: #12a5e5;
          padding: 50px 0;
          min-height: 100vh;
        }

        .service-card {
          background: white;
          width: 92%;
          max-width: 900px;
          margin: auto;
          border-radius: 22px;
          overflow: hidden;
          box-shadow: 0 15px 40px rgba(0,0,0,0.2);
        }

        .service-image {
          width: 100%;
          height: 280px;
          object-fit: cover;
        }

        .service-header {
          display: flex;
          gap: 18px;
          padding: 25px;
          background: #e9f7ff;
          align-items: center;
        }

        .avatar {
          width: 65px;
          height: 65px;
          border-radius: 50%;
        }

        h2, h3 {
          font-weight: bold;
          margin-bottom: 8px;
        }

        .stars {
          color: gold;
          font-size: 18px;
        }

        .box {
          background: #e9f7ff;
          margin: 18px;
          padding: 25px;
          border-radius: 18px;
        }

        .included {
          display: grid;
          grid-template-columns: 1fr 1fr;
          gap: 12px;
        }

        /* ===== Reviews ===== */
        .reviews-header {
          display: flex;
          gap: 35px;
          align-items: center;
          margin-bottom: 25px;
        }

        .overall {
          text-align: center;
        }

        .overall h1 {
          font-size: 50px;
          margin: 0;
          font-weight: bold;
        }

        .rating-bars {
          flex: 1;
        }

        .rating-row {
          display: flex;
          align-items: center;
          gap: 10px;
          margin: 7px 0;
        }

        .bar {
          flex: 1;
          height: 9px;
          background: #ddd;
          border-radius: 6px;
        }

        .fill {
          height: 100%;
          background: gold;
          border-radius: 6px;
        }

        .review {
          margin-top: 18px;
        }

        .footer {
          display: flex;
          justify-content: space-between;
          align-items: center;
          padding: 25px;
          background: #e9f7ff;
        }

        .footer button {
          background: #2563eb;
          color: white;
          border: none;
          padding: 14px 30px;
          border-radius: 12px;
          font-size: 17px;
          font-weight: bold;
          cursor: pointer;
          box-shadow: 0 6px 15px rgba(0,0,0,0.2);
        }

        /* ===== Popup ===== */
        .overlay {
          position: fixed;
          top: 0;
          left: 0;
          width: 100%;
          height: 100%;
          background: rgba(0,0,0,0.45);
          display: flex;
          align-items: center;
          justify-content: center;
        }

        .popup {
          background: white;
          padding: 35px;
          border-radius: 18px;
          text-align: center;
          width: 330px;
          box-shadow: 0 20px 50px rgba(0,0,0,0.3);
          animation: pop 0.3s ease-in-out;
        }

        @keyframes pop {
          from { transform: scale(0.8); opacity: 0; }
          to { transform: scale(1); opacity: 1; }
        }

        .popup h2 {
          color: #2563eb;
        }

        .popup button {
          margin-top: 20px;
          padding: 12px 25px;
          border: none;
          background: #2563eb;
          color: white;
          border-radius: 10px;
          font-size: 15px;
          cursor: pointer;
        }
      `}</style>

      {/* ================= PAGE ================= */}
      <div className="service-page">
        <div className="service-card">

          {/* HOME CLEANING IMAGE */}
          <img
            src="https://images.unsplash.com/photo-1581578731548-c64695cc6952"
            className="service-image"
            alt="Home Cleaning Service"
          />

          <div className="service-header">
            <img
              src="https://randomuser.me/api/portraits/women/44.jpg"
              className="avatar"
              alt="provider"
            />
            <div>
              <h2>Professional Home Cleaning</h2>
              <p>Clean Sweep Co · Available in 5 areas</p>
              <div className="stars">★★★★★ <span style={{color:"#555"}}>4.8 (527 reviews)</span></div>
            </div>
          </div>

          <div className="box">
            <h3>About this Service</h3>
            <p>
              Get your home sparkling clean with our professional cleaning
              service. Our trained team uses eco-friendly products to ensure
              safety and hygiene for your family.
            </p>
          </div>

          <div className="box">
            <h3>What’s Included</h3>
            <div className="included">
              <span>✔ Comprehensive floor cleaning</span>
              <span>✔ Bathroom sanitization</span>
              <span>✔ Window & glass cleaning</span>
              <span>✔ Furniture dusting & vacuuming</span>
              <span>✔ Kitchen deep clean</span>
              <span>✔ Eco-friendly products used</span>
            </div>
          </div>

          {/* CUSTOMER REVIEWS */}
          <div className="box">
            <h3>Customer Reviews</h3>

            <div className="reviews-header">
              <div className="overall">
                <h1>4.8</h1>
                <div className="stars">★★★★★</div>
                <p>527 reviews</p>
              </div>

              <div className="rating-bars">
                <RatingBar stars="5" percent="75%" />
                <RatingBar stars="4" percent="15%" />
                <RatingBar stars="3" percent="6%" />
                <RatingBar stars="2" percent="3%" />
                <RatingBar stars="1" percent="1%" />
              </div>
            </div>

            <div className="review">
              <b>Sarah M.</b>
              <p>Outstanding service! Very punctual and professional.</p>
              <div className="stars">★★★★★</div>
            </div>

            <div className="review">
              <b>John D.</b>
              <p>Highly recommended. My home looks amazing!</p>
              <div className="stars">★★★★☆</div>
            </div>

            <div className="review">
              <b>Priya S.</b>
              <p>Best cleaning service I’ve used. Very reliable.</p>
              <div className="stars">★★★★★</div>
            </div>
          </div>

          <div className="footer">
            <div>
              <span><b>Starting From</b></span>
              <h2>₹499</h2>
            </div>
            <button onClick={() => setShowPopup(true)}>Book Now</button>
          </div>

        </div>
      </div>

      {/* POPUP */}
      {showPopup && (
        <div className="overlay">
          <div className="popup">
            <h2>🎉 Booking Successful!</h2>
            <p>Your home cleaning service has been booked.<br />
               Our professional team will contact you shortly.</p>
            <button onClick={() => setShowPopup(false)}>Done</button>
          </div>
        </div>
      )}
    </>
  );
}

function RatingBar({ stars, percent }) {
  return (
    <div className="rating-row">
      <span>{stars}★</span>
      <div className="bar">
        <div className="fill" style={{ width: percent }}></div>
      </div>
    </div>
  );
}
