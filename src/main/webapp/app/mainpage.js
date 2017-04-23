jQuery(document).ready(function ($) {
    "use strict"; // Start of use strict

   // jQuery for page scrolling feature - requires jQuery Easing plugin
    $(document).on('click', 'a.page-scroll', function(event) {
        $('html, body').animate({
            scrollTop: ($($(this).attr('href')).offset().top - 50)
        }, 'fast');
        event.preventDefault();
    });
     $(document).on('click', 'a.page-scroll-to-additional', function(event) {
         var slideTo = $(this).attr('data-slide-to');
         setTimeout(
             function() {
                 $('html, body').stop().animate({
                     scrollTop: ($("#additional").offset().top - 50)
                 }, 'slow');
                 event.preventDefault();
                 $('#infoCarousel').carousel(parseInt(slideTo));
             },
             150);
    });
     //Burger menu
     $(document).on('click','.navbar-collapse.in',function(e) {
        if( $(e.target).is('a') && $(e.target).attr('class') != 'dropdown-toggle' ) {
            $(this).collapse('hide');
        }
    });

    // Initialize and Configure Scroll Reveal Animation
    window.sr = ScrollReveal();
    sr.reveal('.sr-icons', {
        duration: 600,
        scale: 0.3,
        distance: '0px'
    }, 200);
    sr.reveal('.sr-button', {
        duration: 1000,
        delay: 200
    });
    sr.reveal('.sr-contact', {
        duration: 600,
        scale: 0.3,
        distance: '0px'
    }, 300);
    
    $("body").tooltip({ selector: '[data-toggle=tooltip]' });

});
