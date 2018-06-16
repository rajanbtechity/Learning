
# coding: utf-8

# # Introduction to Dictionaries 2
# 
# Dictionaries can be especially useful when used to represent larger chunks of related data. The image below shows a more realistic "ticket" from the ticketing software known as Jira. 
# 
# Take a look!
# 
# ![Jira Ticket](https://d17h27t6h515a5.cloudfront.net/topher/2017/November/59fb6ccd_jira-ticket/jira-ticket.png)

# In[2]:


# Note how the structure of a ticket is captured in the


ticket = {
    "type" : "bug",
    "status": "done",
    "priority": "medium",
    "resolution": "done",
    "description" : "testing 123",
    "attachments" : [],
    "people": {
        "assignee" : None,
        "reporter" : {
            "name" : "Andy Brown",
            "image": "www.example_image_url.com"
        },
        "votes" : 0,
        "watchers" : [
            {
                "name": "Andy Brown",
                "image": "www.example_image_url.com"  
            }
        ]
    },
    "dates" : {
        "created" : "6 days ago",
        "updated" : "6 days ago",
        "resolved": "6 days ago"
    }
}

# In this example, ticket is a dictionary with the following "keys":

print("The keys for this dictionary are...")
ticket.keys()


# In[3]:


# notice how nicely the following code reads... 

ticket['people']['reporter']['name']


# In[4]:


# let's pull in a bunch of "dummy" data

from sample_data import big_tickets
import random

print("there are", len(big_tickets), "big tickets")


# In[5]:


# grab a random ticket and take a look at it

random_ticket = random.choice(big_tickets)
random_ticket


# ## TODO - Exercise - Find all tickets with 8 or more watchers
# 
# Lists and dictionaries can work together nicely. Notice how in the random ticket shown above the `people` field is a dictionary. That dictionary contains additional data including a `watchers` key whose associated value is a list. 
# 
# In this exercise you will filter a list of 250 tickets (which are each a dictionary) down to a smaller list of only the most popular tickets (as defined by number of watchers).

# In[10]:


def get_popular_tickets(tickets):
    """
    From a list of tickets, fetch all the tickets with 8 or 
    more "watchers". 
    """
    popular_tickets = []
    #
    # TODO - your code here
    # 
    for ticket in tickets:
        str_len=len(ticket['people']['watchers'])
        if str_len>=8:
            popular_tickets.append(ticket)
        
    return popular_tickets

popular = get_popular_tickets(big_tickets)

# TESTING CODE 
assert( len(popular) > 0 ) # must be at least one popular ticket

for ticket in popular:
    assert( len(ticket['people']['watchers']) >= 8 )
    
print("Nice job! It looks like your function is working.")


# In[ ]:


#

#

#

#

#

# Spoiler alert! Try to avoid looking at the solution until you've
# attempted the problem yourself.

#

#

#
def get_popular_tickets_solution(tickets):
    """
    From a list of tickets, fetch all the tickets with 8 or 
    more "watchers". 
    """
    popular_tickets = []
    for ticket in tickets:
        num_watchers = len(ticket['people']['watchers'])
        if num_watchers >= 8:
            popular_tickets.append(ticket)
    return popular_tickets  

