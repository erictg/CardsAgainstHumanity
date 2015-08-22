"""
Definition of urls for CardsAgainstHumanity.
"""

from django.conf.urls import patterns, url
from django.conf.urls import include
from django.contrib import admin
#admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    url(r'^$', 'auth_login_app.views.home', name='home'),
    url(r'^admin/', include(admin.site.urls)),
    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
     
)
