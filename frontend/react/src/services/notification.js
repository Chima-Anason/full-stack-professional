import { createStandaloneToast } from '@chakra-ui/react'

const { toast } = createStandaloneToast()

const notification = (title, description, status) =>{
    toast({
        title,
        description,
        status
    })
}

export const successNotification = (title, description) =>{
    notification(
        title,
        description,
        'success',
        true,
        4000
    )
}
export const errorNotification = (title, description) =>{
    notification(
        title,
        description,
        'error'
    )
}