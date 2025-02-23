/* script.js */
document.addEventListener("DOMContentLoaded", () => {
    // Countdown Timer
    const eventDate = new Date("2025-06-15T09:00:00").getTime();
    const countdown = setInterval(() => {
        const now = new Date().getTime();
        const timeLeft = eventDate - now;
        
        if (timeLeft <= 0) {
            clearInterval(countdown);
            document.querySelector(".cta").innerText = "Event Started!";
        }
    }, 1000);

    // Contact Form Validation
    document.getElementById("contact-form").addEventListener("submit", (e) => {
        e.preventDefault();
        alert("Message Sent Successfully!");
    });
});

// Get all date cards
const dateCards = document.querySelectorAll('.date-card');
const selectedDateText = document.getElementById('selected-date-text');

dateCards.forEach(card => {
    card.addEventListener('click', () => {
        // Remove active class from all
        dateCards.forEach(c => c.classList.remove('active'));

        // Add active class to selected
        card.classList.add('active');

        // Update text above
        selectedDateText.textContent = card.getAttribute('data-date');
    });
});


/*pop up */
// script.js
// Set the date we're counting down to
var countDownDate = new Date("Mar 1, 2025 00:00:00").getTime();

// Update the countdown every 1 second
var x = setInterval(function() {

    // Get today's date and time
    var now = new Date().getTime();

    // Find the distance between now and the count down date
    var distance = countDownDate - now;

    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);

    // Output the result in elements with id="days", "hours", "minutes", "seconds"
    document.getElementById("days").innerHTML = days;
    document.getElementById("hours").innerHTML = hours;
    document.getElementById("minutes").innerHTML = minutes;
    document.getElementById("seconds").innerHTML = seconds;

    // If the count down is over, write some text 
    if (distance < 0) {
        clearInterval(x);
        document.getElementById("countdown").innerHTML = "EXPIRED";
    }
}, 1000);

// Close the popup
document.getElementById('closePopup').addEventListener('click', function() {
    document.getElementById('countdownPopup').style.display = 'none';
});
//About section
document.addEventListener('DOMContentLoaded', () => {
    const listItems = document.querySelectorAll('.about ul li');

    listItems.forEach(item => {
        // Add a data attribute to store the original text
        item.dataset.originalText = item.textContent;

        // Add a click event listener to each list item
        item.addEventListener('click', () => {
            if (!item.classList.contains('expanded')) {
                // Expand the item
                item.classList.add('expanded');
                item.textContent = item.dataset.originalText + ' - Learn more about this topic...'; // Add example content
                item.style.height = 'auto'; // Adjust height to fit content
            } else {
                // Collapse the item
                item.classList.remove('expanded');
                item.textContent = item.dataset.originalText;
                item.style.height = ''; // Reset height
            }
        });
    });

    // Function to trigger animations on scroll (example)
    function checkSlide() {
        const aboutSection = document.querySelector('.about');
        const slideInAt = (window.scrollY + window.innerHeight) - aboutSection.offsetHeight / 2;
        const sectionBottom = aboutSection.offsetTop + aboutSection.offsetHeight;
        const isHalfShown = slideInAt > aboutSection.offsetTop;
        const isNotScrolledPast = window.scrollY < sectionBottom;

        if (isHalfShown && isNotScrolledPast) {
            aboutSection.classList.add('active'); // Add active class to trigger animations
        } else {
            aboutSection.classList.remove('active');
        }
    }

    window.addEventListener('scroll', checkSlide);
});
// 1. Dynamically load Speakers
function loadSpeakers() {
    fetch('speakers.json')
      .then(response => response.json())
      .then(data => {
        const speakersContainer = document.querySelector('.speakers-container');
        
        // Clear existing content
        speakersContainer.innerHTML = '';
        
        // Create speaker cards from JSON data
        data.forEach(speaker => {
          const card = document.createElement('div');
          card.classList.add('speaker-card');
          card.innerHTML = `
            <img src="${speaker.image}" alt="${speaker.name}">
            <h3>${speaker.name}</h3>
            <p>${speaker.role}</p>
            <p>${speaker.company}</p>
          `;
          speakersContainer.appendChild(card);
        });
      })
      .catch(error => {
        console.error('Error fetching speakers:', error);
      });
  }
  
  // 2. Dynamically load Schedule & handle track filtering
  function loadSchedule() {
    fetch('schedule.json')
      .then(response => response.json())
      .then(sessions => {
        // Default display: show all tracks
        displaySchedule(sessions, 'all');
  
        // Handle track filter changes
        const trackFilter = document.getElementById('trackFilter');
        trackFilter.addEventListener('change', () => {
          const selectedTrack = trackFilter.value;
          displaySchedule(sessions, selectedTrack);
        });
      })
      .catch(error => {
        console.error('Error fetching schedule:', error);
      });
  }
  
  // 3. Helper function to display schedule items
  function displaySchedule(sessions, track) {
    const container = document.getElementById('dynamicScheduleContainer');
    container.innerHTML = ''; // Clear old sessions
  
    // Filter by track if not "all"
    const filteredSessions = track === 'all'
      ? sessions
      : sessions.filter(session => session.track === track);
  
    // Create and append session elements
    filteredSessions.forEach(session => {
      const sessionDiv = document.createElement('div');
      sessionDiv.classList.add('session-card');
      sessionDiv.style.background = '#222';
      sessionDiv.style.padding = '15px';
      sessionDiv.style.margin = '10px 0';
      sessionDiv.style.borderRadius = '8px';
      
      sessionDiv.innerHTML = `
        <h3 style="color:#ff6600;">${session.title}</h3>
        <p>${session.date}</p>
        <p>${session.description}</p>
        <p><strong>Track:</strong> ${session.track}</p>
      `;
      container.appendChild(sessionDiv);
    });
  }
  
  // 4. Initialize everything on DOMContentLoaded
  document.addEventListener('DOMContentLoaded', () => {
    // Existing code (countdown, contact form, etc.)
    
    // Load dynamic content
    loadSpeakers();
    loadSchedule();
  });
  
