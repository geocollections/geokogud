jQuery(document).ready(function ($) {
    "use strict"; // Start of use strict

   // jQuery for page scrolling feature - requires jQuery Easing plugin
    $(document).on('click', 'a.page-scroll', function(event) {
        $('html, body').stop().animate({
            scrollTop: ($($(this).attr('href')).offset().top - 50)
        }, 'slow');
        event.preventDefault();
    });
     $(document).on('click', 'a.page-scroll-to-searches', function(event) {
        $('html, body').stop().animate({
            scrollTop: ($("#searches").offset().top - 50)
        }, 'slow');
        event.preventDefault();
    });
     $(document).on('click', 'a.page-scroll-to-additional', function(event) {
         setTimeout(
             function() {
                 $('html, body').stop().animate({
                     scrollTop: ($("#additional").offset().top - 50)
                 }, 'slow');
                 event.preventDefault();
             },
             50);
    });
     $(document).on('click','.navbar-collapse.in',function(e) {
        if( $(e.target).is('a') && $(e.target).attr('class') != 'dropdown-toggle' ) {
            $(this).collapse('hide');
        }
    });

    // Highlight the top nav as scrolling occurs
    /* $('body').scrollspy({
        target: '.navbar-fixed-top',
        offset: 51
    });
     */
    // Offset for Main Navigation
    $('#mainNav').affix({
        offset: {
            top: 100
        }
    })

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
