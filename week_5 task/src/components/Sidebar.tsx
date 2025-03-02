import { Drawer, DrawerBody, DrawerHeader, DrawerOverlay, DrawerContent, DrawerCloseButton, Button, useDisclosure, VStack } from "@chakra-ui/react";
function Sidebar() {
  const { isOpen, onOpen, onClose } = useDisclosure();
  return (
    <>
      <Button onClick={onOpen} fontFamily={'inherit'} colorScheme="gray" mb={4}>Filter</Button>
      <Drawer isOpen={isOpen} placement="left" onClose={onClose}>
        <DrawerOverlay />
        <DrawerContent>
          <DrawerCloseButton />
          <DrawerHeader fontFamily={'inherit'} >Game Categories</DrawerHeader>
          <DrawerBody>
            <VStack align="start">
              <Button fontFamily={'inherit'} variant="ghost">Action</Button>
              <Button fontFamily={'inherit'} variant="ghost">Racing</Button>
              <Button fontFamily={'inherit'} variant="ghost">Horror</Button>
              <Button fontFamily={'inherit'} variant="ghost">Strategy</Button>
            </VStack>
          </DrawerBody>
        </DrawerContent>
      </Drawer>
    </>
  );
}
export default Sidebar;