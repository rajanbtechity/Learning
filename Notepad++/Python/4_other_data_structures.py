
# coding: utf-8

# # Other Data Structures [optional]
# 
# The purpose of this notebook is to show you some of the many other data structures you can use without going into too much detail. You can learn more by reading [documentation from Python's collections library](https://docs.python.org/3.3/library/collections.html).

# ## 1. Tuples
# 
# The only standard library data structure that we haven't discussed. The tuple is an immutable (unchangeable) sequence of Python objects.
# 
# The tuple is very similar to a list. You can read more about it in the [Python tuple documentation](https://docs.python.org/3/tutorial/datastructures.html#tuples-and-sequences)

# In[7]:


# tuples are created with (parentheses)

my_tuple = (1,2,3)
print(my_tuple)
print(type(my_tuple))


# In[2]:


# elements can be accessed just like they are with lists.

print( my_tuple[0] )
print( my_tuple[1] )
print( my_tuple[2] )


# In[3]:


# there are some things you can't do with tuples 
# due to them being immutable.

my_tuple[1] = 4


# In[4]:


# but there are also some things you CAN do with tuples
# that you can't do with lists...

t1 = ('a','b','c')
t2 = (1, 2, 3)

set_of_tuples = set()

set_of_tuples.add(t1)
set_of_tuples.add(t2)

print(set_of_tuples)


# In[5]:


L1 = ['a','b','c']
L2 = [1, 2, 3]

set_of_lists = set()

set_of_lists.add(L1)
set_of_lists.add(L2)

print(set_of_lists)


# ## 2. Namedtuple
# 
# Very similar to a tuple except the fields can be named as well! I use namedtuples when I want to use `object.property` notation but don't want to define a full class.

# In[8]:


# named tuple's need to be imported from the collections library
from collections import namedtuple

# here we define Point as a new type of thing. 
# It has properties x and y.
Point = namedtuple("Point", ["x", "y"])

# here we actually instantiate a point
p1 = Point(5, -3)

print(p1)


# In[9]:


# there are two ways to access the fields in a point...

# ... by position
print( p1[0] )
print( p1[1] )


# In[10]:


# ... or by name

print( p1.x )
print( p1.y )


# ## 3. Counter
# Often we want to count how many times something occurs. The code below demonstrates how to use a `Counter` to count the number of occurrences of various characters in a string.

# In[1]:


from collections import Counter

string = "the quick brown fox jumped over the lazy dog"

character_counter = Counter()
for character in string:
    character_counter[character] += 1
    
character_counter.most_common()


# It looks like this string had 8 spaces, 4 e's, 4 o's, etc...

# In[2]:


# something that's nice about counters is that they don't throw 
# an error if you try to access a key that isn't there. Instead
# they return 0.

# how many capital A's are in the string above?

print(character_counter["A"])


# In[3]:


# but how many lowercase a's?

print(character_counter["a"])


# ## 4. defaultdict
# 
# A default dict is best explained by example. Let's go back to the "three boxes of tickets" example from earlier.

# In[4]:


TICKET_BOXES = {
    "low"    : [],
    "medium" : [],
    "high"   : []
}

unfiled_tickets = [
    {
        "priority"    : "high",
        "description" : "slammed on brakes"
    },
    {
        "priority"    : "low",
        "description" : "windshield chipped"
    },
    {
        "priority"    : "low",
        "description" : "failed to use turn signal"
    }
    ,
    {
        "priority"    : "medium",
        "description" : "did not come to complete stop at stop sign"
    }
]

def file_ticket(ticket):
    priority = ticket['priority']
    TICKET_BOXES[priority].append(ticket)
    
for ticket in unfiled_tickets:
    file_ticket(ticket)
    
print(TICKET_BOXES)


# In[5]:


# so far so good! But what if we try to file a ticket
# with a priority "highest" (as we saw in Jira)?

new_ticket = {
    "priority" : "highest",
    "description": "vehicle crashed!"
}

file_ticket(new_ticket)


# In[6]:


# as expected, we get a key error... one way to fix this
# is as follows

def file_ticket_fixed(ticket):
    priority = ticket['priority']
    
    # new code
    if priority not in TICKET_BOXES:
        TICKET_BOXES[priority] = []
        
    TICKET_BOXES[priority].append(ticket)

file_ticket_fixed(new_ticket)
print(TICKET_BOXES)


# In[7]:


# OR we can use a "defaultdict" 
from collections import defaultdict

TICKET_BOXES = defaultdict(list) # notice the argument of list...

def file_ticket(ticket):
    priority = ticket['priority']
    TICKET_BOXES[priority].append(ticket)

for ticket in unfiled_tickets:
    file_ticket(ticket)
    
file_ticket(new_ticket)

print(TICKET_BOXES)


# When you try to access a key that doesn't exist, defaultdict adds that key to the dictionary and associates a **default** value with it (in this case a list).
# 
# If you want to learn more you can read the [documentation on defaultdict](https://docs.python.org/3.3/library/collections.html#collections.defaultdict)

# ## 5. Other data structures from `collections`

# In[8]:


from collections import deque, OrderedDict


# In[9]:


d = deque([4,5,6])
print(d)


# In[10]:


d.append(7)
print(d)


# In[11]:


d.appendleft(3)
print(d)


# In[12]:


last = d.pop()
print("last element was", last)
print("now d is", d)


# In[13]:


first = d.popleft()
print("first element was", first)
print("now d is", d)


# In[14]:


# # # # #


# In[15]:


od = OrderedDict()


# In[16]:


od['a'] = 1
od['b'] = 2
od['c'] = 3


# In[17]:


# as the name implies, an OrderedDict is a dictionary that
# keeps track of the order in which elements were added.

print(od)

