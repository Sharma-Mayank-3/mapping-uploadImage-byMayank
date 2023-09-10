# mapping-uploadImage-byMayank
A small project on Upload image and mapping between entity

# Upload Image 
# 2 Approach of uploading image

# Approach 1, upload image in folder in project.
1. File Service.
2. Upload file and serve file by file name.(image).

# Approach 2, Cloudinary External Cloud to upload image
link : https://console.cloudinary.com/console/c-157e4ae73eb558df62d728a732ee69

# Mapping 
# ----------------------------------------------------

# One to One Mapping, between User and Aadhar Entity.
# User Entity, Aadhar Entity.

1. pass both image and raw data of user as a RequestParam and convert raw text to 
   userDto using object mapper.
2. By-Direction mapping so find User From Aadhar or Aadhar from User not an issue.
3. Either comment one of the dto or else continuous response.
4. Observation in One-One-mapping 
 Note : In Lazy or Eager : if we delete User(Parent), then Aadhar (Child) will get deleted.
        If we try to delete Aadhar (Child) then neither child nor User (Parent) will get delete.


# One to Many Mapping 
# Country and State Entity

1. By-Direction mapping so find state From country is not an issue
2. But Find Country from state using findBy or query is an issue, so solution is 
   get state from stateId, there country is already present so pass country back in that api.
3. In Fetch Type Lazy: delete Country(parent) state(child) will get delete.
4. In Fetch Type Lazy: delete state(child) state will get delete but country(parent) will not get delete.

5. In Fetch Type EAGER: delete Country(parent) state(child) will get delete.
6. In Fetch Type EAGER: delete state(child) state will Not get delete also country(parent) will not get delete.




