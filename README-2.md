# HallEase — Full Stack Function Hall Booking System

A GitHub + Render ready Full Stack Function Hall Booking application.

## Included features
- Five selectable function halls: Royal Grand Hall, Pearl Function Hall, Garden Celebration Hall, Crystal Palace Hall, Grand Convention Hall
- Hall cards with location, capacity and price
- Date-based availability checking
- Duplicate booking prevention for the same hall and date
- Customer details and event type
- Guest count and extra chairs
- Chair packages
- Basic / Classic / Premium decoration
- UPI / Card / Pay at Venue payment selection (demo flow)
- Automatic total and 25% advance calculation
- Booking confirmation with Booking ID
- PostgreSQL persistence through Spring Boot REST API
- Booking History from the database
- Responsive mobile UI
- GitHub and Render deployment files

## Stack
Frontend: HTML5 + CSS3 + JavaScript
Backend: Java 17 + Spring Boot REST API
Database: PostgreSQL
Deployment: GitHub + Render

## Project structure
frontend/
backend/
render.yaml

## GitHub
Upload the complete project folder to one repository. Keep `frontend`, `backend`, and `render.yaml` in the repository root.

## Render
Use **New → Blueprint** after pushing to GitHub. The included `render.yaml` configures the backend and PostgreSQL database.

Deploy `frontend` as a Render Static Site. After the backend is deployed, change `window.API_BASE` in `frontend/index.html` to:
`https://YOUR-BACKEND.onrender.com/api`

For local development, start PostgreSQL, run `mvn spring-boot:run` from `backend`, then open `frontend/index.html`.

## Important
The payment selection is a demo. No real card/UPI credentials are collected. For production, integrate a real payment gateway and verify payment server-side.

## Function Hall History
The application also includes **Hall-wise Booking History**:
- Select any function hall.
- View all bookings for that hall.
- See booking date, customer, event, guests, payment method and status.
- See total number of bookings and total booking value for that hall.
- Data is loaded from PostgreSQL through the Spring Boot API.
- API: `GET /api/bookings/hall/{hallId}/history`


## Final booking confirmation
When the user clicks **Create Booking & Confirm** and the backend successfully saves the booking, the UI displays a **Booking Completed!** confirmation screen containing:
- Booking ID
- Selected hall
- Booking date
- Total amount
- 25% advance
- CONFIRMED status
- Done button
- Print Confirmation button

The booking is also immediately available in Booking History.


## Function Hall selection fix
Click **Function Halls** in the navigation. The application now displays:
1. Royal Grand Hall
2. Pearl Function Hall
3. Garden Celebration Hall
4. Crystal Palace Hall
5. Grand Convention Hall

Each card has **Select Hall**. The selected hall is carried into the booking form. A frontend fallback list is also included, so the names remain visible while the Spring Boot API is starting.
